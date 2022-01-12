import org.junit.Test;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * @Author: Ryan
 * @Date: 2021/4/15 16:59
 * @Version: 1.0
 * @Description:
 */
public class BasicTest {

    /**
     * BigDecimal 的负数 相反数
     */
    @Test
    public void testBigDecimal() {
        BigDecimal decimal = new BigDecimal("-2.5");
        BigDecimal negate = decimal.negate();
        System.out.println(decimal); // -2.5
        System.out.println(negate); // 2.5
    }

    /**
     * 文本替代
     */
    @Test
    public void messageFormatTest() {
        String format = MessageFormat.format("用户{0}的{1}级分享用户", "155", 1);
        System.out.println(format);

        String str = "this is a test!";
        System.out.println(MessageFormat.format("MessageFormat方法：{0}这是{1}的使用", str ,"占位符"));
    }

    @Test
    public void floatTest() {
        float f = 12.5f;
        float f2 = 15f;
        float fl = (f - f2) / 100;
        System.out.println(fl);
    }

    /**
     * 微信字符串截取为时间
     */
    @Test
    public void strTest() {
        String str = "20210605154609";
        String year = str.substring(0, 4);
        String month = str.substring(4, 6);
        String day = str.substring(6, 8);
        String hour = str.substring(8, 10);
        String minute = str.substring(10, 12);
        String second = str.substring(12);
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
    }

    @Test
    public void intTest() {
        int i = 3;
        int n = i / 2;
        System.out.println(n);
    }

    @Test
    public void countAdd() {
        int count = 0;
        System.out.println(count++);
        System.out.println(count);
        System.out.println(++count);
        System.out.println(count);
    }

    @Test
    public void testString() {
        System.out.println(null == null);
        System.out.println("".equals(null));
    }
}
