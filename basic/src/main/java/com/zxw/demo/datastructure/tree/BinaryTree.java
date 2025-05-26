package com.zxw.demo.datastructure.tree;

import java.math.BigDecimal;

/**
 * @Author: Ryan
 * @Date: 2025/5/22 11:26
 * @Version: 1.0
 * @Description: 二叉树
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 数据大小
     */
    int size;

    public int size() {
        return size;
    }

    /**
     * 插入数据
     */
    public void add(Object value) {
        // 不存 null 值，因为 null 值无法比较且无意义
        if (value == null) {
            return;
        }

        Node addNode = new Node(value);

        // 根节点为空则放到根节点
        if (root == null) {
            root = addNode;
        } else {
            // 根节点不为空
            for (Node x = root; ; ) {
                int compare = compareValue(x.value, value);
                if (compare > 0) {
                    if (x.left == null) {
                        x.left = addNode;
                        break;
                    } else {
                        x = x.left;
                    }
                } else if (compare < 0) {
                    if (x.right == null) {
                        x.right = addNode;
                        break;
                    } else {
                        x = x.right;
                    }
                } else {
                    // 等值情况，不进行插入
                    System.out.printf("The value [%s] has been existed, won't be add again!%n", value);
                }
            }
        }

        size++;
    }

    /**
     * 查找数据
     */
    public Object search(Object value) {
        if (value == null) {
            return null;
        }

        Node searchNode = searchNode(root, value);

        return searchNode == null ? null : searchNode.value;
    }

    /**
     * 删除节点
     * <p>
     * 删除的规则：
     *      1、如果要删除的节点没有子节点了，那直接删除就行（设置为空）
     *      2、如果有一个子节点，直接把子节点的值设置到当前需要删除节点的位置
     *      3、如果有两个子节点，则找到比删除节点值大的节点中最小的那个节点（删除节点的右边节点然后一直向左找到最后的左节点，就是后继节点）
     */
    public void remove(Object value) {
        if (value == null) {
            return;
        }

        Node extendNode = removeNode(root, value);

        // 第一层返回值没有处理，其实就是根节点删除时的返回值
        if (compareValue(root.value, value) == 0) {
            root = extendNode;
        }

    }

    /**
     * 删除节点
     * <p>
     * 除了找到的等值节点，上面的节点都是原样返回去；
     */
    private Node removeNode(Node current, Object value) {
        if (current == null) {
            return null;
        }

        int compare = compareValue(current.value, value);

        // 删除值小于当前节点值
        if (compare > 0) {
            current.left = removeNode(current.left, value);
            return current;
        }

        // 删除值大于当前节点值
        if (compare < 0) {
            current.right = removeNode(current.right, value);
            return current;
        }

        Node resNode = null;

        // 删除值等于当前节点值
        // 如果当前左子节点为空，则返回右子节点
        // 这里为什么写 else if，写 else if 可以少判断一次两个同时为空
        if (current.left == null) {
            resNode = current.right;
        } else if (current.right == null) {
            // 右子节点为空则返回左子节点
            resNode = current.left;

        } else {
            // 左右子节点都不为空
            current.right = lift(current.right, current);
            resNode = current;
        }

        size--;
        return resNode;
    }

    /**
     * 向下查找后继节点（有两个子节点的情况）
     */
    private Node lift(Node current, Node removeNode) {
        // 有左子节点，则从左子节点找出后继节点
        if (current.left != null) {
            current.left = lift(current.left, removeNode);
            return current;
        } else {
            // 无左子节点，则说明当前节点是后继节点，将其值设置到被需要删除的节点中去
            removeNode.value = current.value;
            // 后继节点的右子节点替代后继节点父节点的左子节点😵
            // 就是说当前的后继节点被拿到前面去代替删除节点的位置了，所以这个位置需要补上，用当前后继节点的右子节点补上
            // 返回去是当前父节点的左子节点位置
            return current.right;
        }
    }

    /**
     * 查找值对应的节点（递归）
     */
    private Node searchNode(Node current, Object value) {
        if (current == null) {
            return null;
        }

        Node searchNode;

        int compare = compareValue(current.value, value);
        // 当前节点值大于比较值（要找的值），在左边查找
        if (compare > 0) {
            searchNode = searchNode(current.left, value);
        } else if (compare < 0) {
            searchNode = searchNode(current.right, value);
        } else {
            searchNode = current;
        }

        return searchNode;
    }

    /**
     * 比较两节点的大小
     *
     * @param current 当前值
     * @param value 比较的数据
     * @return 比较结果
     */
    private int compareValue(Object current, Object value) {
        if (current instanceof Number && value instanceof Number) {
            BigDecimal cb = new BigDecimal(current.toString());
            BigDecimal vb = new BigDecimal(value.toString());

            return cb.compareTo(vb);
        }
        return current.toString().compareTo(value.toString());
    }

    static class Node {

        /**
         * 数据
         */
        Object value;

        /**
         * 左节点
         */
        Node left;

        /**
         * 右节点
         */
        Node right;

        public Node() {

        }

        public Node(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
