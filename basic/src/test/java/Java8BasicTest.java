import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2021/9/10 18:02
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class Java8BasicTest {

    @Test
    public void optionalTest() {
        Optional<String> optionalS = Optional.empty();
        log.info("-----> optionalS:{} <-----", optionalS);
        boolean present = optionalS.isPresent();
        log.info("-----> present:{} <-----", present);
        Optional<String> zhongqiu = Optional.of("zhongqiu");
        boolean zhongqiuPresent = zhongqiu.isPresent();
        log.info("-----> zhongqiuPresent:{} <-----", zhongqiuPresent);
//        String s = optionalS.get(); 空的取值会报错 notSuchElement
        String zhongqiuS = zhongqiu.get();
//        log.info("-----> s:{} <-----", s);
        log.info("-----> zhongqiuS:{} <-----", zhongqiuS);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class T {
        private String var;
        private String var2;
    }

    /**
     * toMap 转 map 测试用例
     *
     * 需要注意的情况, key 和 value 都有坑
     * 结合此类 {@link com.zxw_work.lambda.LambdaDemo}, 此包为 lambda 相关 demo
     */
    @Test
    public void test2() {
        T t = new T("var", "var2");
        T t2 = new T(null, "var2_");
        T t3 = new T("var_", null);
        T t4 = new T(null, "var2__");

//        ArrayList<T> ts = Lists.newArrayList(t, t1, t2);
        ArrayList<T> ts = Lists.newArrayList(t, t2, t3, t4);

        // toMap 转 map 的时候 value 为 null 会报错空指针异常，key 重复会报错 主键冲突异常 duplicate
//        Map<String, String> map1 = ts.stream().collect(Collectors.toMap(T::getVar, T::getVar2));

        // 解决方法一：value 为空取空串（如果可以，有些场景不行），相同 key 指定策略不变或者替换
        Map<String, String> map = ts.stream().collect(Collectors.toMap(T::getVar, var2 ->
                Optional.ofNullable(var2.getVar2()).orElse(""), (v1, v2) -> v2));

        // 解决方法二（推荐）：按照 hashMap 的策略进行抉择，利用 hashMap 去进行 put 操作
        Map<String, String> mapN = ts.stream().collect(HashMap::new, (mapInner, item) ->
                mapInner.put(item.getVar(), item.getVar2()), HashMap::putAll);

        log.info("map:{}", map);
        log.info("mapN:{}", mapN);
    }
}
