package com.zxw_work.entity;

import lombok.*;

/**
 * @Author: Ryan
 * @Date: 2024/11/11 15:42
 * @Version: 1.0
 * @Description: add the description
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Money {

    private long cent = 0;

    /**
     * 累加到当前数据，会改变数据
     */
    public Money add(Money oth) {
        this.cent = this.cent + oth.cent;
        return this;
    }
}
