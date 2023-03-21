package com.zxw.demo.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
     *
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
}
