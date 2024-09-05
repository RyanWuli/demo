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

    /**
     * precision()
     * scale()
     */
    @Test
    public void test20240828() {
        String str = "150.15";
        BigDecimal bigDecimal = new BigDecimal(str);
        // 总位数
        int precision = bigDecimal.precision();
        // 小数位数
        int scale = bigDecimal.scale();
        log.info("precision:{}, scale:{}", precision, scale);

        log.info("0.0:{}", new BigDecimal("0.0"));
        log.info("0:{}", new BigDecimal("0"));
        log.info("000.000:{}", new BigDecimal("000.000"));
    }
}
