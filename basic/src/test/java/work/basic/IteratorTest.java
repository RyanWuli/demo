package work.basic;

import com.google.common.collect.Lists;
import com.zxw.demo.string.StrClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: Ryan
 * @Date: 2024/8/9 15:18
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class IteratorTest {

    @Test
    public void testIteratorNext() {

        ArrayList<StrClass> strClasses = Lists.newArrayList(new StrClass("ryan1", "111", "aaa"),
                new StrClass("ryan2", "222", "bbb"),
                new StrClass("ryan3", "333", "ccc"));

        Iterator<StrClass> iterator = strClasses.iterator();

        log.info("res:{}", iterator.next().getName());

    }
}
