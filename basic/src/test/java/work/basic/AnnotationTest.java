package work.basic;

import com.zxw_work.biz.MyBiz;
import com.zxw_work.interruptor.Interruptor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: Ryan
 * @Date: 2024/11/5 16:05
 * @Version: 1.0
 * @Description: 注解测试
 */
@Slf4j
public class AnnotationTest {

    /**
     * 只能根据类找到某个注解的方法，一般是遍历所有类，如 spring 的扫描包就是加载大量的类
     */
    @Test
    public void testFindMethodByAnnotation() {
        Method[] declaredMethods = MyBiz.class.getDeclaredMethods();
        log.info("declaredMethods:{}", declaredMethods);

        log.info("annotation name:{}", Interruptor.class.getCanonicalName());
        log.info("annotation toString:{}", Interruptor.class.toString());
    }

}
