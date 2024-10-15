package work.biz;

import com.zxw_work.biz.Biz;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Ryan
 * @Date: 2024/9/6 9:59
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class BizTest {

    /**
     * 唯一 code 生成
     */
    @Test
    public void testUniqueCode() {
        for (int i = 0; i < 5; i++) {
            log.info("code" + (i + 1) + ":{}", Biz.getUniqueCode());
        }
    }

    @Test
    public void test() {
        log.info("hex:{}", Integer.toHexString(16));
        log.info("dateHex:{}", Integer.toHexString(20251111));
        log.info("dateMinHex:{}", Integer.toHexString(19700101));
        log.info("dateMaxHex:{}", Integer.toHexString(29991212));
        log.info("dateHash:{}", "20251111".hashCode());
    }

}
