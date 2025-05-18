package work.interupttor;

import com.zxw_work.biz.MyBiz;
import com.zxw_work.biz.MyClass;
import com.zxw_work.interruptor.BeanFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/11/6 10:32
 * @Version: 1.0
 * @Description: 拦截器测试
 */
@Slf4j
public class InterruptTest {

    @Test
    public void testInterrupt() {
        MyBiz myBiz = BeanFactory.instance().getBean(MyBiz.class);
        log.info("myBiz:{}", myBiz);

        if (null != myBiz) {
            myBiz.myBizMethod("已拦截");
            myBiz.myBizMethod2("未拦截");
        }

        log.info("----------------------");

        MyClass myClass = BeanFactory.instance().getBean(MyClass.class);
        log.info("MyClass:{}", myClass);

        if (null != myClass) {
            myClass.myClassMethod("0");
            myClass.myClassMethod1("1");
        }
    }

}
