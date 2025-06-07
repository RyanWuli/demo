import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zxw.demo.object.ObjectDemo;
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
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2021/4/15 16:59
 * @Version: 1.0
 * @Description: java basic/tools test
 */
@Slf4j(topic = "BasicTest")
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

    /**
     * object equals test
     * <p>
     * 谁调用 equals 方法 [x.equals()]，就调用谁[x]的 equals 方法
     * 如果没有重写则执行 object 的 equals 方法
     * 对应面向对象的多态特性理解
     */
    @Test
    public void testObjectEquals() {
        // string 类型转成 object 调用 equals 还是以实际类型为准，也就是调用 string 类重写的 equals 方法；
        String str1 = "equalsStr";
        String str2 = "equalsStr";

        Object obj1 = (Object) str1;
        Object obj2 = (Object) str2;

        System.out.println(obj1.equals(obj2));



        // 同上以实际 string 类型的 equals 执行
        Object obj3 = "equalsStrObj";
        Object obj4 = "equalsStrObj";
        System.out.println(obj3.equals(obj4));



        // 同上以实际的 string 类型的重写方法比较执行
        Object obj5 = new String("newStr");
        Object obj6 = new String("newStr");
        System.out.println(obj5.equals(obj6));



        // 这里还是走的 string 的比较方法
        Object obj7 = new String("newStr");
        Object obj8 = new Person();
        System.out.println(obj7.equals(obj8));

    }

    /**
     * 比较任意类型大小？
     */
    @Test
    public void testCompare() {
        String str1 = "A";
        String str2 = "B";

        System.out.println(str2.compareTo(str1));

        String str3 = "C++";
        String str4 = "Java";
        System.out.println(str3.compareTo(str4));

        String str5 = "5";
        String str6 = "6";
        System.out.println(str6.compareTo(str5));
    }

    @Test
    public void testScanner() {
        Scanner in = new Scanner(System.in);

        int i = in.nextInt();

        log.info("i:{}", i);
    }

    public static final Marker keyWord = MarkerFactory.getMarker("告警");

    @Test
    public void testSl4jLog() {
        String mes = "失败";
        log.info(keyWord, "xxx 业务异常：{}", mes);
    }

    @Test
    public void testIterator() {
        /*
        Iterator 遍历原理其实就是一个游标 cursor ，获取一下一个 next 之后，游标往下移一个
         */

        ArrayList<Integer> integerList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        Iterator<Integer> iterator = integerList.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

    }

    @Test
    public void testConvertDefault() {
        ObjectDemo.convertDefault();
    }

}
