package com.zxw.demo.list.util;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 * @Author: Ryan
 * @Date: 2022/1/12 17:41
 * @Version: 1.0
 * @Description: add the description
 */
public class NullItemHandler extends AbstractList<Object> implements RandomAccess, Serializable {

    public static final Collection instance = (List)new NullItemHandler();

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean contains(Object obj) {
        return null == obj;
    }

    private Object readResolve() {
        return null;
    }
}
