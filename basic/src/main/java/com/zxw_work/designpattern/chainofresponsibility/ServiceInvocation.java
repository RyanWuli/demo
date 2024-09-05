package com.zxw_work.designpattern.chainofresponsibility;

import com.zxw_work.designpattern.chainofresponsibility.interfaces.Invocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Ryan
 * @Date: 2024/9/2 16:33
 * @Version: 1.0
 * @Description: add the description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInvocation implements Invocation {

    private String methodName;

    @Override
    public String getMethodName() {
        return this.methodName;
    }
}
