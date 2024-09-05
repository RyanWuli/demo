package com.zxw_work.designpattern.chainofresponsibility;

import com.google.common.collect.Lists;
import com.zxw_work.designpattern.chainofresponsibility.annotate.Activate;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Filter;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Invoker;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 14:42
 * @Version: 1.0
 * @Description: 链工厂
 *                  这里只有一个方法，应用的时候可以作为一个工厂使用
 */
public class ChainFactory {

    public static Invoker buildFilterInvoke(Invoker invoker) {

        // 加载 Filter 资源（这里是个懒加载）
        ServiceLoader<Filter> filterLoader = ServiceLoader.load(Filter.class);

        if (!filterLoader.iterator().hasNext()) {
            return invoker;
        }

        List<Filter> filters = Lists.newArrayList();

        // 最终执行的 invoker
        Invoker last = invoker;

        // 遍历使用的时候才会真正加载
        for (Filter filter : filterLoader) {

            filters.add(filter);

        }

        // order 按照 DESC 降序排列，order 小的包在最外层最先开始执行
        List<Filter> filtersSort = filters.stream().sorted((filter1, filter2) -> {
            Activate annotation1 = filter1.getClass().getAnnotation(Activate.class);
            Activate annotation2 = filter2.getClass().getAnnotation(Activate.class);

            if (annotation1.order() > annotation2.order()) {
                return -1;
            } else if (annotation1.order() == annotation2.order()) {
                return 0;
            }

            return 1;
        }).collect(Collectors.toList());


        for (Filter filter : filtersSort) {

            // 如果有过滤器，则把最终执行的 invoker 设置为下一个执行
            Invoker next = last;

            // 这里通过把新的过滤器执行当成最后一个 invoker，把前面的执行器作为参数传入 filter 中执行，filter 中会执行下一个 invoker；
            // 这样包装之后最外层执行的 invoker 实际上是最后一个 filter 的 invoke 方法，所以需要注意的是 filter 的排序问题，
            // 如果 order 小的需要先执行（包在最外层），则 filter 排序的时候需要按照 DESC 降序排列；
            // 大致的链路就是，第一个 invoker1 执行的时候，执行 order 最小的 filter1#invoke(invoker2),
            // filter1 在执行到 invoker2#invoke() 的时候，invoke() 实现中又是下一个 filter2#invoke(invoker3)，
            // 此时 filter1 中的 invoker2#invoke() 后面的代码都还未执行，filter2 在执行到 invoker3.invoke() 的时候，
            // invoke() 实现又是下一个 filter3#invoke(invoker4), 同样 filter2 中 invoker3.invoke() 后面的代码也未执行......
            // 依次知道最后的 invoker(n)#invoke() 不在是 filter 而是具体业务逻辑的时候，filter 链串联完成但并没有执行完成，
            // 还需要反向 filter(n-1)->...->filter3->filter2->filter1 依次执行各个 filter 中的 invoker#invocke() 后面的代码，
            // 也就是例如 filter3 整个执行完成之后，相当于 filter2 中 invoker3.invoke() 执行完成，
            // 然后立马执行 invoker3.invoke() 之后的代码，完成了 filter2 中逻辑，
            // 同理会执行 filter1 中 invoker2#invoke() 之后的逻辑；
            // 整体看下来就是 filter 链中一层一层包裹，每个 filter 执行到 invoker#invoke() 的时候都会去执行下一个 filter，
            // 然后执行到最终逻辑，再反向执行各个 filter 中的 invoker#invoke() 之后的逻辑，最后执行到最外层的 filter 完成然后返回结果。
            last = invocation -> filter.invoke(next, invocation);
        }

        return last;

    }

}
