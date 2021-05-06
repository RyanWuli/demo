import org.junit.Test;

import java.util.Map;
import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2021/4/15 16:59
 * @Version: 1.0
 * @Description:
 */
public class RandomTest {

    Random random = new Random();

    @Test
    public void random() {

        while (true) {
            System.out.println(random.nextInt(10)); // 10 以内的证书 不包含
        }
    }

    /**
     * 区间取整数数据
     * @throws InterruptedException
     */
    @Test
    public void randomSection() throws InterruptedException {
//        random.nextInt(max) % (max - min + 1) + min
        //Math.floor(Math.random() * (m - n + 1)) + n;
        int max = 95, min = 55;
        int n = random.nextInt(max) % (max - min + 1) + min;

        // 方法一 整数
//        while (true) {
//            Thread.sleep(500);
//            System.out.println(random.nextInt(max) % (max - min + 1) + min);
//        }

        // 方法二 浮点整数
        while (true) {
            Thread.sleep(500);
            System.out.println(Math.floor(Math.random() * (max - min + 1)) + min);
        }
    }
}
