import com.zxw.demo.datastructure.linkedlist.LinkedList;
import com.zxw.demo.datastructure.linkedlist.doublelinkedlist.DoubleLinkedList;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2025/5/20 16:35
 * @Version: 1.0
 * @Description: 数据结构测试类
 */
public class DataStructureTest {

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

    @Test
    public void testDoubleLinkedList() {
        DoubleLinkedList dll = new DoubleLinkedList();

        // 默认插入（尾插）
        dll.add("C");
        dll.add("Go");
        dll.add("C++");
        dll.add("Java");
        dll.add("Scala");
        System.out.println(dll.add("Python"));

        // 指定位置插入
        System.out.println(dll.add(3, "PHP"));
        // 头插
        dll.add(0, "SQL");
        // 尾插
        dll.add(8, "Java Script");

        System.out.println(dll.remove("php"));
        System.out.println(dll.remove("PHP"));
        System.out.println(dll.remove("SQL"));
        System.out.println(dll.remove("Java Script"));

        System.out.println(dll.size());
        System.out.println(dll);
    }

}
