package com.zxw_work.entity;

import lombok.*;

import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2024/11/8 15:10
 * @Version: 1.0
 * @Description: add the description
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Req02 extends Request {

    List<Money> list;

}
