import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zxw.demo.string.StrClass;
import com.zxw.demo.string.StringUtil;
import com.zxw.entity.Person;
import com.zxw_work.designpattern.chainofresponsibility.interfaces.Filter;
import com.zxw_work.entity.XxxReq;
import com.zxw_work.entity.XxxRes;
import com.zxw_work.thread.ServerContext;
import com.zxw_work.thread.ServerContextHolder;
import com.zxw_work.time.PeriodDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.List;
import java.util.ServiceLoader;
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

    @Test
    public void testHash() {
        System.out.println(new Object().hashCode()); // 1450821318
        System.out.println(new Person().hashCode());

        String str = "str";

        System.out.println(str);

        System.out.println(str.toCharArray());

        char[] chars = "字符串".toCharArray();

        for (char aChar : chars) {

            System.out.println(aChar);

        }

        char c = '字';

        System.out.println((int) c);

    }

    /**
     * 测试类字段 string 去掉首位空串
     */
    @Test
    public void testTrimAllFields() throws InterruptedException {
        StrClass strClass = new StrClass("  Ryan    ", "   18723605266     ", "     中国重庆铜梁  ", 25);
        log.info("oriStr:{}", strClass);
        StringUtil.trimAllFields(strClass);
        log.info("afterOri:{}", strClass);

        StrClass strClass2 = new StrClass("  Ryan2    ", "   187236052662     ", "cqtl", 15);
        log.info("oriStr2:{}", strClass2);
        StringUtil.trimAllFields2(strClass2);
        log.info("afterOri2:{}", strClass2);


//        StrClass strClass = new StrClass("  Ryan    ", "   18723605266     ", null, 25);
//        StrClass strClass2 = new StrClass("  Ryan2    ", "   187236052662     ", "cqtl", 15);
//        log.info("oriStr:{}", strClass);
//        StrClass strClass1 = StringUtil.trimAllFields(strClass);
//        log.info("afterOri:{}", strClass);
//        log.info("afterTrimStr:{}", strClass1);
//        log.info("strClass2:{}", strClass2);
//
//        log.info("fields:{}", JSON.toJSONString(strClass.getClass().getDeclaredFields()));


        // multi thread test
//        String name = "  Ryan";
//        int age = 0;
//        String mobile = "  18723605266";
//        String addr = "  zgcqtl";
//
//        AtomicBoolean hold = new AtomicBoolean(false);
//
//        for (int i = 0; i < 100; i++) {
//            StrClass strClass3 = new StrClass(name + i, mobile + i, addr + i, age + i);
//            log.info("trim-before-strClass" + i + ":{}", strClass3);
//
//            int finalI = i;
//            new Thread(() -> {
//
//                while (true) {
//
//                    if (hold.get()) {
//                        StringUtil.trimAllFields(strClass3);
//                        log.info("trim-before-strClass" + finalI + ":{}", strClass3);
//                        return;
//                    }
//
//                }
//
//
//            }, "thread" + i).start();
//        }
//
//        Thread.sleep(5000);
//
//        hold.set(true);
//
//        Thread.sleep(5000);
//
//        log.info("test over...");

    }

    /**
     * 接口实现类反射加载
     *
     * @see ServiceLoader
     */
    @Test
    public void testReflex() {
        ServiceLoader<Filter> serviceLoader = ServiceLoader.load(Filter.class);
        log.info("serviceLoader:{}", JSON.toJSONString(serviceLoader));

        for (Filter filter : serviceLoader) {
            log.info("filter:{}", filter.getClass().getName());
        }
    }

    /**
     * 创建临时默认文件夹
     *
     * @throws IOException io 异常
     */
    @Test
    public void testFilePath() throws IOException {

        // 生成临时文件夹（绝对路径） C:\\Users\\Ryan\\AppData\\Local\\Temp\\test1689332085362274585
        Path tempDirectory = Files.createTempDirectory("test");
        log.info("tempDirectory:{}", JSON.toJSONString(tempDirectory));

    }

    /**
     * period test
     */
    @Test
    public void testPeriod() {
        PeriodDemo.period();
    }

    @Test
    public void testThreadLocal() {
        ServerContextHolder.set(new ServerContext<>(new XxxReq(), new XxxRes()));
//        ServerContext<XxxReq, XxxRes> serverContext = (ServerContext<XxxReq, XxxRes>) ServerContextHolder.getUnknown();
        ServerContext<XxxReq, XxxRes> current = ServerContextHolder.get();
    }
}
