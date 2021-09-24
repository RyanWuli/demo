import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @Author: Ryan
 * @Date: 2021/9/10 18:02
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class Java8BasicTest {

    @Test
    public void optionalTest() {
        Optional<String> optionalS = Optional.empty();
        log.info("-----> optionalS:{} <-----", optionalS);
        boolean present = optionalS.isPresent();
        log.info("-----> present:{} <-----", present);
        Optional<String> zhongqiu = Optional.of("zhongqiu");
        boolean zhongqiuPresent = zhongqiu.isPresent();
        log.info("-----> zhongqiuPresent:{} <-----", zhongqiuPresent);
//        String s = optionalS.get(); 空的取值会报错 notSuchElement
        String zhongqiuS = zhongqiu.get();
//        log.info("-----> s:{} <-----", s);
        log.info("-----> zhongqiuS:{} <-----", zhongqiuS);
    }
}
