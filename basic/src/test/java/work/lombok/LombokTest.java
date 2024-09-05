package work.lombok;

import com.zxw_work.lombok.LombokDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/9/4 15:41
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class LombokTest {

    private final LombokDemo lombokDemo = new LombokDemo();

    @Test
    public void testSneakThrows() {
        lombokDemo.lombokSneakThrows();
        log.info("end...");
    }

}
