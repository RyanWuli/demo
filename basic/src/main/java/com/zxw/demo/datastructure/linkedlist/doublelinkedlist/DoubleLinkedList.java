package com.zxw.demo.datastructure.linkedlist.doublelinkedlist;

/**
 * @Author: Ryan
 * @Date: 2025/5/21 10:19
 * @Version: 1.0
 * @Description: 双向链表
 *                  目前只实现了部分功能，其它功能有时间也可以实现一下，参照 {@link java.util.LinkedList}
 */
public class DoubleLinkedList {

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 链表长度
     */
    private int size;

    /**
     * 获取头节点
     */
    public Node head() {
        return head;
    }

    /**
     * 获取尾节点
     */
    public Node tail() {
        return tail;
    }

    /**
     * 获取链表长度
     */
    public int size() {
        return size;
    }

    /**
     * 插入数据（默认尾插）
     */
    public boolean add(Object value) {
        Node t = tail;
        // 尾插前是插入之前的尾，后节点为空（最后一个）
        Node newNode = new Node(value, t, null);
        // 尾插新增节点放尾部
        tail = newNode;

        // 如果尾部插入之前尾部为空，则说明没有数据
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }

        size++;

        return true;
    }

    /**
     * 指定位置插入
     */
    public boolean add(int index, Object value) {
        checkPositionIndex(index);

        // 插入位置在最后一个位置（size - 1） 之后，则就是尾插
        if (index == size) {
            add(value);
        } else {
            Node positionNode = node(index);
            Node positionPrev = positionNode.prev;
            Node newNode = new Node(value, positionPrev, positionNode);

            // 原该位置节点的前节点应该是新节点了
            positionNode.prev = newNode;
            // 如果原该位置的前节点不为空，则原前节点的后节点应该是新节点了
            if (positionPrev != null) {
                positionPrev.next = newNode;
            } else {
                // 如果原前节点为空说明是头插，更新头节点就行
                head = newNode;
            }
            size++;
        }

        return true;
    }

    /**
     * 移除数据
     */
    public boolean remove(Object value) {
        for (Node n = head; n != null; n = n.next) {
            if (compareValue(value, n.value)) {
                unlink(n);
                return true;
            }
        }
        return false;
    }

    /**
     * 解除关联（删除）
     */
    private Object unlink(Node n) {
        Node next = n.next;
        Node prev = n.prev;
        Object value = n.value;

        if (prev != null) {
            prev.next = next;
            // 这里解除一下引用
            n.prev = null;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
            n.next = null;
        } else {
            tail = prev;
        }

        n.value = null;
        size--;
        return value;
    }

    /**
     * 数据对比
     */
    private boolean compareValue(Object val, Object value) {
        if (val == null && value == null) {
            return true;
        } else if (val != null && value != null) {
            return val.equals(value);
        } else {
            return false;
        }
    }

    /**
     * 通过下标查找节点
     */
    private Node node(int index) {
        Node current;

        // 小于一半从头部开始查找
        if (index < (size >> 1)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // 大于一半从尾部开始查找
            current = tail;
            for (int j = size - 1; j > index; j--) {
                current = current.prev;
            }
        }

        return current;
    }

    /**
     * 检查位置正确性
     */
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IllegalArgumentException("position index error, please check...");
        }
    }

    public static class Node {

        /**
         * 数据
         */
        private Object value;

        /**
         * 上一个节点
         */
        private Node prev;

        /**
         * 下一个节点
         */
        private Node next;

        /**
         * 获取节点数据
         */
        public Object value() {
            return value;
        }

        /**
         * 获取上一个节点
         */
        public Node prev() {
            return prev;
        }

        /**
         * 获取下一个节点
         */
        public Node next() {
            return next;
        }

        public Node() {
        }

        public Node(Object value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return (prev == null ? "" : "←") + value + (next == null ? "" : ("→" + next));
        }
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" + head + "}";
    }
}
