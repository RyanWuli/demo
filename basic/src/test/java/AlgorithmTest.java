import com.zxw.demo.algorithm.Sort;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/6/24 14:21
 * @Version: 1.0
 * @Description: 算法测试类
 */
@Slf4j
public class AlgorithmTest {

    /**
     * 冒泡排序测试
     */
    @Test
    public void testBubbleSort() {
        // 6, 5, 7, 0, 9, 4, 3, 6, 5, 6, 7, 3, 4, 3, 7
        // 9, 8, 7, 6, 5, 4, 3, 2, 1
        // 3, 4, 5, 8, 6, 4, 5, 0, 2, 0, 5, 5, 4, 0, 0, 6, 4, 9, 4, 6, 8, 5, 9, 9, 8, 5, 4, 7, 8,
        //                3, 6, 7, 5, 2, 3, 4, 1, 3, 1, 5, 3, 5, 1, 9, 5, 2, 3, 0, 8, 1, 7, 1, 9, 8
        int[] array = new int[]{5, 8, 9, 7, 6, 0, 4, 1, 2, 0, 3, 1, 0, 1, 0};

        Sort.bubbleSorting(array);

        log.info("array:{}", array);
    }

}
