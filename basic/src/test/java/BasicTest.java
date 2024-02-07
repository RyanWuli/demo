import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2021/4/15 16:59
 * @Version: 1.0
 * @Description: java basic/tools test
 */
@Slf4j
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

    /**
     * String 占位符替换文本
     *
     * <p>String.format 可以实现文本替换
     * <p>%s 表示替换文本的位置
     * <p>notExistAccountNos.stream().collect(Collectors.joining(",")) 可以把集合内容用符号隔开拼成一个字符串
     * <p>String.join(",", notExistAccountNos2) 也是把集合内容用指定的符号分隔组成一个字符串（推荐使用这个）
     */
    @Test
    public void testStringFormat() {
        List<String> notExistAccountNos = Lists.newArrayList("123", "456");
        List<String> notExistAccountNos2 = Lists.newArrayList("789", "10");
        String str = notExistAccountNos.stream().collect(Collectors.joining(","));
        String res = String.format("账号%s不存在！", notExistAccountNos.stream().collect(Collectors.joining(",")));
        String res2 = String.format("账号%s不存在！", String.join(",", notExistAccountNos2));
        log.info("res:{}, res2:{}", res, res2);
    }
}
