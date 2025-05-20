import com.zxw.demo.datastructure.linkedlist.LinkedList;
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

}
