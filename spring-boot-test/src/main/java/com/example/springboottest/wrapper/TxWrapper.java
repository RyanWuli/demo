package com.example.springboottest.wrapper;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 14:51
 * @Version: 1.0
 * @Description: 事务包装
 *                  后续可以写在 spring boot starter 里面，公用引用包直接注入使用
 */
@Component
public class TxWrapper {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void withNewTx(TxCallback callback) {
        callback.doWithNewTx();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public <T> T withNewTx(TxReturnCallback<T> callback) {
        return callback.doWithNewTx();
    }

    /**
     * 无返回值的回调
     */
    public interface TxCallback {
        void doWithNewTx();
    }

    /**
     * 有返回值的回调
     */
    public interface TxReturnCallback<T> {
        T doWithNewTx();
    }

}
