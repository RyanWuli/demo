package work.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Ryan
 * @Date: 2024/3/14 11:39
 * @Version: 1.0
 * @Description: 构造器测试
 */
@Slf4j
public class ConstructorTest {

    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException {
        // Class 表示类对象、类本身，Class<?> 表示，类的对象注意不是实例，
        // 比如创建（加载）一个类 Person，会生成一个对象是 Person Class 对象
        Class<?> classC = Class.forName("work.basic.ConstructorTest");
        log.info("class:{}", classC);
        Constructor<?> constructor = classC.getConstructor();
        Constructor<?>[] constructors = classC.getConstructors();
        log.info("constructor:{}", constructor);
        log.info("constructor:{}", constructors);
    }

    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.zxw.entity.Person");
        Constructor<?> constructor = aClass.getConstructor();
        // 构建对象（必须有对应的参数构造器，否则出错）
        Object o = constructor.newInstance(new Object[0]);
        log.info("o:{}", o);
    }
}
