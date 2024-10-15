package com.zxw_work.biz;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;
import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2024/9/6 9:46
 * @Version: 1.0
 * @Description: add the description
 */
public class Biz {

    private static Random random = new Random();

    /**
     * 唯一 code 生成(18 位)
     *
     * random.nextInt(100000) 只是模拟数字，需要利用数据库（insert on dup update）等实现自增且不重复
     * 支持每天生成最多 99999999999 个 code，更多可以扩展位数
     */
    public static String getUniqueCode() {
        String yyyyMMdd = FastDateFormat.getInstance("yyyyMMdd").format(new Date());

        // 7位16进制，至少说 1970-2999 年，只会是7位
        String yyyyMMddHex = Integer.toHexString(Integer.parseInt(yyyyMMdd));

        // 7位(16进制) + 11位(序号，如:00000000001)
        return yyyyMMddHex + String.format("%011d", random.nextInt(100000));
    }

}
