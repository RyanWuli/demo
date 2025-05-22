package com.zxw.demo.datastructure.linkedlist;

/**
 * @Author: Ryan
 * @Date: 2025/5/20 16:20
 * @Version: 1.0
 * @Description: 链表
 */
public class LinkedList {

    /**
     * 链表初始节点
     */
    private Node first;

    /**
     * 链表数据大小
     */
    private long size;

    /**
     * 新增数据
     * @param value 数据
     */
    public void add(Object value) {
        // 数据封装为一个节点
        Node node = new Node();
        node.setValue(value);

        // 初始节点为空，则放入初始节点；否则放在第一个下一个节点为空的节点的下一个节点中
        if (first == null) {
            first = node;
        } else {
            Node current = first;
            while (current.hasNext()) {
                current = current.getNext();
            }
            current.setNext(node);
        }

        // 计数
        size++;
    }

    /**
     * 获取链表数据大小
     */
    public long size() {
        return size;
    }

    /**
     * 插入（指定位置新增）
     * @param index 下标
     * @param value 数据
     */
    public void add(long index, Object value) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("index out of size, please check...");
        }

        Node current = new Node();
        current.setValue(value);

        Node item;

        // 插入第一个位置
        if (index == 0) {
            // 第一个节点放在当前的下一个节点
            current.setNext(first);
            // 第一节个点放当前节点
            first = current;
        } else if (index == size) {
            // 因为下标最大是 size - 1，所以 size 位置就是尾插
            item = first;
            while (item.hasNext()) {
                item = item.getNext();
            }
            item.setNext(current);
        } else {
            // 中间插, 需要保存当前位置以及上一个位置的节点
            Node lastItem;
            lastItem = first;
            item = first.getNext();

            // 从位置1开始
            long num = 1L;

            while (num < index) {
                lastItem = item;
                item = item.getNext();
                num++;
            }

            lastItem.setNext(current);
            // 把以前的当前下标位置放到当前的下一个
            current.setNext(item);
        }

        size++;
    }

    public boolean remove(Object value) {
        if (size == 0) {
            return false;
        }

        Node last = null;
        Node current  = first;

        do {
            Object val = current.getValue();

            if (compareValue(val, value)) {
                if (last == null) {
                    first = current.getNext();
                } else {
                    last.setNext(current.getNext());
                }
                size--;
                return true;
            }

            last = current;
            current = current.getNext();
        } while (current != null);

        return false;

    }

    private boolean compareValue(Object val, Object value) {
        if (val == null && value == null) {
            return true;
        } else if (val != null && value != null) {
            return val.equals(value);
        } else {
            return false;
        }
    }

    private void doRemove(Node last, Node current, Node removeNod) {

    }

    @Override
    public String toString() {
        return "LinkedList{" + first + "}";
    }
}
