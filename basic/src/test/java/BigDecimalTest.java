import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author: Ryan
 * @Date: 2021/8/18 17:21
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class BigDecimalTest {

    /**
     * 新建数字指定小数位数
     */
    @Test
    public void test() {
        BigDecimal bigDecimal = BigDecimal.valueOf(1000, 2);
        log.info("----- bigDecimal:{} -----", bigDecimal);
    }

    @Test
    public void pointMoveTest() {
        BigDecimal bigDecimal = BigDecimal.valueOf(23.98);
        BigDecimal res = bigDecimal.movePointRight(2);
        System.out.println(res);
    }
}
