package com.zxw.demo.datastructure.linkedlist;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Ryan
 * @Date: 2025/5/20 16:16
 * @Version: 1.0
 * @Description: 节点
 */
@Getter
@Setter
public class Node {

    /**
     * 数据
     */
    private Object value;

    /**
     * 下一个节点
     */
    private Node next;

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return value + (next == null ? "" : "→" + next);
    }
}
