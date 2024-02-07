package work.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2024/2/5 14:27
 * @Version: 1.0
 * @Description: common lang3 工具包日期转换用例
 */
@Slf4j
public class DateFormatTest {

    @Test
    public void testFastDateFormat() {
        // 日期转字符串
        String yyMMdd = FastDateFormat.getInstance("yyMMdd").format(new Date());
        log.info("yyMMdd:{}", yyMMdd);
    }

}
