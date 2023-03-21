package com.zxw.demo.algorithm;

import org.junit.Test;

import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2023/3/1 16:24
 * @Version: 1.0
 * @Description: 初级算法
 */
public class BeginnerAlgorithm {

    /**
     * 删除升序排列数组的重复数据，并返回最后的数组大小
     *
     * 原地删除（不产生新的容器）
     */
    @Test
    public void deleteRepeat() {
        class Algorithm {
            private int deleteRepeat(int[] descArray) {
                for (int i = 0; i < descArray.length; i++) {
                    while ((i + 1) <= descArray.length)
                    if (descArray[i] == descArray[i+1]){
                        // TODO: 2023/3/21  
                        // descArray.
                    }
                }
                return 0;
            }
        }
    }
}
