package com.zxw.demo;

/**
 * @Author: Ryan
 * @Date: 2021/1/9 10:01
 * @Version: 1.0
 * @Description:
 */
public class tm {

    public static void main(String[] args) {

        int m = 320; // 总斤数
        int p = 11200; // 总金额
        int h = (int) Math.round(m * 0.1); // 总斤数的 10%
        int t = 0; // 计数
        int x; // 统货斤数
        int y; // 三级斤数
        int z; // 二级斤数
        int j; // 一级斤数
        int k; // 特级斤数
        int a = 18; // 统货价格
        int b = 28; // 三级价格
        int c = 37; // 二级价格
        int d = 48; // 一级价格
        int e = 72; // 特级价格
        for (x = h; x <= 320; x++) {
            for (y = h; y <= (320 - x); y++) {
                for (z = h; z <= (320 - x - y); z++) {
                    for (j = h; j <= (320 - x - y - z); j++) {
                        for (k = h; k <= (320 - x - y - z - j); k++) {
                            int i = x + y + z + j + k;
                            int n = (x * a) + (y * b) + (z * c) + (j * d) + (k * e);
                            if (i == 320 && n == p && x > y && y > z && z > j && j > k) {
                                System.out.println("第" + (t + 1) + "种情况:-----" + "统货：" + x + "斤，" + "三级：" + y + "斤，" +
                                        "二级：" + z + "斤，" + "一级：" + j + "斤，" + "特级：" + k + "斤，");
                                t++;
                            }
                        }
                    }
                }
            }
        }
    }
}
