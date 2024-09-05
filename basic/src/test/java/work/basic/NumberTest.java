package work.basic;

import org.junit.Test;

import java.text.NumberFormat;

/**
 * @Author: Ryan
 * @Date: 2024/5/6 10:50
 * @Version: 1.0
 * @Description: add the description
 */
public class NumberTest {

    @Test
    public void test01() {
        // 数字格式化
        System.out.println(NumberFormat.getInstance().format((double) 345654754L / 1000));
        System.out.println((double) 345654754L / 1000);

        /*
        输出：
        345,654.754
        345654.754
         */
    }

}
