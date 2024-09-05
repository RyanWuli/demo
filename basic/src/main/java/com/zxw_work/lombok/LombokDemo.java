package com.zxw_work.lombok;

import lombok.SneakyThrows;

/**
 * @Author: Ryan
 * @Date: 2024/9/4 15:35
 * @Version: 1.0
 * @Description: add the description
 */
public class LombokDemo {

    /**
     * @SneakyThrows 好像没用，嗯...有空再看看
     */
    @SneakyThrows
    public void lombokSneakThrows() {
        throw new RuntimeException("sneakThrows...");
    }

}
