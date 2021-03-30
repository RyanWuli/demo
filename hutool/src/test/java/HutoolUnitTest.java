import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2021/3/8 14:42
 * @Version: 1.0
 * @Description:
 */

public class HutoolUnitTest {

    @Test
    public void testDate() {
        Date date = new Date();
        DateTime newDate = DateUtil.offsetMonth(date, -1);
        System.out.println(newDate);
    }


    @Test
    public void date2() {
        String today = DateUtil.today();
        DateTime parse = DateUtil.parse(today);
        System.out.println("------------------> parse:" + parse);

    }
}
