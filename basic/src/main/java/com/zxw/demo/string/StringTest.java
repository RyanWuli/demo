package com.zxw.demo.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author: Ryan
 * @Date: 2022/6/27 19:59
 * @Version: 1.0
 * @Description: 字符串测试
 */
@Slf4j
public class StringTest {

    /**
     * 测试空字符串长度
     * <p>
     * 空格为一个长度，
     * 无空格为0
     */
    @Test
    public void testEmptyString() {
        String str = "  ";
        log.info("----- str:{}", str.length());
    }

    @Test
    public void testFormat() {
        System.out.printf("%04d%n", 5L);
        System.out.printf("%04d%n", 55L);
    }

    @Test
    public void testNullString() {
        System.out.println(String.valueOf(null));
    }

    @Test
    public void testHashCode() {
        String str = "ryan瑞恩";
        System.out.println(str.hashCode());
    }

    /**
     * 字符串反转
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }

        char[] arr = str.toCharArray();
        ;

        int cl = 0;
        int cr = str.length() - 1;

        // 字符串反转对调
        change(arr, cl, cr);

        return new String(arr);
    }

    /**
     * 交换字符
     */
    private static void change(char[] arr, int cl, int cr) {
        char temp;
        if (cl < cr) {
            temp = arr[cl];
            arr[cl++] = arr[cr];
            arr[cr--] = temp;

            // 递归调用交换字符方法
            change(arr, cl, cr);
        }
    }

    /**
     * 字符串地址问题
     * <p>
     * 总结：
     * <ul>
     *     <li>直接赋值字符串和 new 出来的字符串地址是不同的，直接赋值的是常量池的内存地址，new 出来的是堆内地址</li>
     *     <li>new 出来的对象会在静态区（常量池）创建对象（如果常量池不存在的话），并且堆内存中也会创建对象，堆内存中指向常量池中的对象</li>
     * </ul>
     */
    public static void stringCompare() {
        String str1 = "zxw";
        String str2 = new String("zxw");
        String str3 = "zxw";

        // 11:30:34.648 [main] INFO com.zxw.demo.string.StringTest - str1 add:2eafffde, str2 add:59690aa4, str3 add:2eafffde
        log.info("str1 add:{}, str2 add:{}, str3 add:{}", Integer.toHexString(System.identityHashCode(str1)),
                Integer.toHexString(System.identityHashCode(str2)), Integer.toHexString(System.identityHashCode(str3)));

        str1 = "zxw2";
        // 13:51:25.271 [main] INFO com.zxw.demo.string.StringTest - str1:zxw2, address:490d6c15
        log.info("str1:{}, address:{}", str1, Integer.toHexString(System.identityHashCode(str1)));
    }

    /**
     * 更改字符串的值
     *
     * <ul>
     *     <li>首先字符串 String 类的值是不可变的，final 修饰的 char[]，在给 String 类型对象 str 赋值另一个字符串的时候，
     *     str 指向的地址（常量池）就变了</li>
     *     <li>但是，可以通过反射机制更改 String 类型的值，此方式变更的时候会将原字符串（aaa）的常量池的值更改（bbb），
     *     并且后续该字符串（aaa）的值都是 bbb 了，常量池可以理解为类似于一个 map 映射，第一次创建的时候以字符串为 key 和 value，
     *     反射机制修改之后会修改大常量池的 value，而 key 的值不变，所以字符串 aaa 对应的值都会是 bbb </li>
     *     <li>new String("aaa") 如果常量池没有 aaa 对象的话就会生成两个对象，一个常量池对象，一个堆内存的对象，堆内存的对象指向常量池对象；
     *     如果常量池已经存在了 aaa 对象，则只会创建一个堆内存对象</li>
     * </ul>
     */
    public static void updateString(String str) {
        if (str == null) {
            return;
        }

        try {
            // 反射加载 String 类的 value 属性
            Field value = String.class.getDeclaredField("value");
            // 设置访问权限
            value.setAccessible(true);
            char[] arr = (char[]) value.get(str);
            arr[0] = 'M';
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
