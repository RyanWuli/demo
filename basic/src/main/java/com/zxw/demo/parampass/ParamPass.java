package com.zxw.demo.parampass;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/5/16 9:17
 * @Version: 1.0
 * @Description: 参数传递
 */
@Slf4j
public class ParamPass {

    public static void intParamPass() {
        int i = 10;
        int j = 100;

        changeInt1(i, j);

        log.info("after change1: i:{}, j:{}", i, j);

        changeInt2(i, j);

        log.info("after change2: i:{}, j:{}", i, j);
    }

    private static void changeInt1(int i, int j) {
        i--;
        j--;
        log.info("change1: i:{}, j:{}", i, j);
    }

    private static void changeInt2(int i, int j) {
        i--;
        j--;
        log.info("change2: i:{}, j:{}", i, j);
    }

}
