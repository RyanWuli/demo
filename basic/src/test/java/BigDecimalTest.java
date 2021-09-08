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

    @Test
    public void test() {
        BigDecimal bigDecimal = BigDecimal.valueOf(1000, 2);
        log.info("----- bigDecimal:{} -----", bigDecimal);
    }
}
