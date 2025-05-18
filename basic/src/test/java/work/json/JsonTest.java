package work.json;

import com.zxw_work.json.JsonDemo;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/12/2 11:39
 * @Version: 1.0
 * @Description: add the description
 */
public class JsonTest {

    /**
     * json 测试用例01
     * <p>
     * get 命名的方法会被 json 序列化 为字符串
     */
    @Test
    public void test01() {
        JsonDemo.testJson01();
    }

}
