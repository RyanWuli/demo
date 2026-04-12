package work;

import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2026/3/19 10:18
 * @Version: 1.0
 * @Description: add the description
 */
public class TempTest {

    @Test
    public void test() {
        methodA();
        methodC(() -> {
            System.out.println("CCC");
            if (isSkip()) {
                return;
            }
            methodD();
        });
        methodB();
    }

    public void methodA() {
        System.out.println("AAA");
    }

    public void methodB() {
        System.out.println("BBB");
    }

    public void methodC(Runnable runnable) {
        runnable.run();
    }

    public void methodD() {
        System.out.println("DDD");
    }

    public boolean isSkip() {
        return true;
    }

}
