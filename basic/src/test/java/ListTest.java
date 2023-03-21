import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/9/24 9:11
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class ListTest {

    @Test
    public void listSortTest() throws InterruptedException {
        List<Date> dates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            dates.add(new Date());
        }

        List<String> dateStrList = new ArrayList<>();
        for (Date date : dates) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(date);
            dateStrList.add(format);
        }

        System.out.println("----- dates:" + dates);
        System.out.println("----- dateStrList:" + dateStrList);
    }

    /**
     * 测试空数组不会执行循环
     */
    @Test
    public void listTest() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(i);
        }
    }

    @Test
    public void iteratorTest() {
        List<String> strList = new ArrayList<>();
        strList.add("zhangsan");
        Iterator<String> iterator = strList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(1);
//            strList.add("xx");
//            strList.remove(next);
            iterator.remove();
        }

        System.out.println(strList);
    }
}
