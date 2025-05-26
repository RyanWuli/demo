import com.zxw.demo.datastructure.linkedlist.LinkedList;
import com.zxw.demo.datastructure.linkedlist.doublelinkedlist.DoubleLinkedList;
import com.zxw.demo.datastructure.tree.BinaryTree;
import org.junit.Test;

import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2025/5/20 16:35
 * @Version: 1.0
 * @Description: 数据结构测试类
 */
public class DataStructureTest {

    private Random random = new Random();

    /**
     * 链表测试
     */
    @Test
    public void testLinkedList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("java");
        linkedList.add("c++");

        linkedList.add(2, "python");
        linkedList.add(1, "c");

        System.out.println(linkedList.remove("rust"));

        System.out.println(linkedList.size());
        System.out.println(linkedList);
    }

    /**
     * 双向链表测试
     */
    @Test
    public void testDoubleLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        // 默认插入（尾插）
        doubleLinkedList.add("C");
        doubleLinkedList.add("Go");
        doubleLinkedList.add("C++");
        doubleLinkedList.add("Java");
        doubleLinkedList.add("Scala");
        System.out.println(doubleLinkedList.add("Python"));

        // 指定位置插入
        System.out.println(doubleLinkedList.add(3, "PHP"));
        // 头插
        doubleLinkedList.add(0, "SQL");
        // 尾插
        doubleLinkedList.add(8, "Java Script");

        System.out.println(doubleLinkedList.remove("php"));
        System.out.println(doubleLinkedList.remove("PHP"));
        System.out.println(doubleLinkedList.remove("SQL"));
        System.out.println(doubleLinkedList.remove("Java Script"));

        System.out.println(doubleLinkedList.size());
        System.out.println(doubleLinkedList);
    }

    /**
     * 二叉树测试
     */
    @Test
    public void testBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();

        // 新增
//        for (int i = 0; i < 10; i++) {
//            binaryTree.add(random.nextInt(100));
//        }

        binaryTree.add(26);
        binaryTree.add(61);
        binaryTree.add(57);
        binaryTree.add(44);
        binaryTree.add(42);
        binaryTree.add(5);
        binaryTree.add(60);
        binaryTree.add(58);
        binaryTree.add(59);
        binaryTree.add(84);

        System.out.println("binaryTree add all:" + binaryTree);
        System.out.println("size add all:" + binaryTree.size());

        // 查找
        System.out.println(binaryTree.search(5));

        binaryTree.remove(1);

        System.out.println("binaryTree remove - 1:" + binaryTree);
        System.out.println("size remove - 1:" + binaryTree.size());

        binaryTree.remove(5);
        System.out.println("binaryTree remove - 5:" + binaryTree);
        System.out.println("size remove - 5:" + binaryTree.size());

        binaryTree.remove(26);
        System.out.println("binaryTree remove - 26:" + binaryTree);
        System.out.println("size remove - 26:" + binaryTree.size());

        binaryTree.remove(57);
        System.out.println("binaryTree remove - 57:" + binaryTree);
        System.out.println("size remove - 57:" + binaryTree.size());


    }

}
