import com.zxw.demo.io.ByteStream;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Ryan
 * @Date: 2024/6/24 17:49
 * @Version: 1.0
 * @Description: IO 测试
 */
@Slf4j
public class IOTest {

    public final static byte[] DEF_BYTES = new byte[]{1, 2, 3, 4, 5};

    public final static String FILE_PATH_IN = "D:\\data\\zxw\\Study\\MCA\\zxw\\file\\from\\in_out_buffer.txt";

    public final static String FILE_PATH_OUT = "D:\\data\\zxw\\Study\\MCA\\zxw\\file\\to\\in_out_buffer3.txt";

    @Test
    public void testByteInput() {
        ByteStream.byteArrayInput(DEF_BYTES);
    }

    @Test
    public void testByteOutPut() {
        log.info("bytes:{}", ByteStream.byteArrayOutput(DEF_BYTES));
    }

    @Test
    public void testFileInput() {
        log.info("文件字节数组：{}", ByteStream.fileInput(FILE_PATH_IN));
    }

    @Test
    public void testFileOutput() {
        ByteStream.fileOutput(FILE_PATH_OUT, ByteStream.fileInput(FILE_PATH_IN));
    }

    @Test
    public void testFileInOutBuffered() {
        ByteStream.fileInOutBuffered(FILE_PATH_IN, FILE_PATH_OUT);
    }

    @Test
    public void testPipedInOut() {
        String str = "Test pipedInOut more than 256: 1582546430652-614513234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./iofsanfaojfiooijfomcmnvvvvvvvvvvvvvvvvvvvv03409434q4okjfqmf9=0-9\\[o]op[oo'l;kgsjhj/.,xnbxc/znb```21`12343425679-08=-09!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?iuholkjb=0k9'iojnj;qwwwwwwafsasavc";
        ByteStream.pipedInOut(str);

    }

    @Test
    public void test() {
        String s = "Test pipedInOut";
        byte[] bytes = s.getBytes();
        log.info("byte:{}", bytes);
        String str = Arrays.toString(bytes);
        log.info("str:{}", str);
    }

}
