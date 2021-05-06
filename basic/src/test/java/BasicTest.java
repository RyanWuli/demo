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
}
