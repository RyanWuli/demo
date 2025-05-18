package work.biz;

import com.zxw_work.biz.Biz;
import com.zxw_work.entity.ConverterGenerateParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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


//        File file = new File();
        String path = Biz.class.getResource("").getPath();
        log.info("path:{}", path);
    }

    @Test
    public void testVc() {
        String tp = "my name is ${name}";

        Map<String, Object> data = new HashMap<>();
        data.put("name", "Ryan");

        String newStr = Biz.templateReplace(tp, data);
        log.info("newStr:{}", newStr);
    }

    @Test
    public void testFile() throws IOException {
        String outPath = "D:\\workplace\\Code\\demo\\basic\\src\\main\\java\\com\\zxw_work\\entity\\out";
        String outName = outPath + "\\" + "A.java";
        File outFile = new File(outName);
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
    }

    @Test
    public void testGenerateTemplate() throws IOException {
        ConverterGenerateParam param = Biz.buildParam();
        Biz.generateConverter(param);
    }

}
