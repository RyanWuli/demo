package com.zxw_work.designpattern.chainofresponsibility;

import com.zxw_work.designpattern.chainofresponsibility.interfaces.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 16:50
 * @Version: 1.0
 * @Description: add the description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp implements Result {

    Object resp;

    @Override
    public Object getResult() {
        return resp;
    }
}
