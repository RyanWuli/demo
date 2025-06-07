import com.alibaba.fastjson.JSON;
import com.zxw.demo.algorithm.Sort;
import com.zxw.demo.algorithm.dijkstra.Dijkstra;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2024/6/24 14:21
 * @Version: 1.0
 * @Description: 算法测试类
 */
@Slf4j
public class AlgorithmTest {

    private final Random random = new Random();

    /**
     * 冒泡排序测试
     */
    @Test
    public void testBubbleSort() {
        // 6, 5, 7, 0, 9, 4, 3, 6, 5, 6, 7, 3, 4, 3, 7
        // 9, 8, 7, 6, 5, 4, 3, 2, 1
        // 3, 4, 5, 8, 6, 4, 5, 0, 2, 0, 5, 5, 4, 0, 0, 6, 4, 9, 4, 6, 8, 5, 9, 9, 8, 5, 4, 7, 8,
        //                3, 6, 7, 5, 2, 3, 4, 1, 3, 1, 5, 3, 5, 1, 9, 5, 2, 3, 0, 8, 1, 7, 1, 9, 8
        int[] array = new int[]{5, 8, 9, 7, 6, 0, 4, 1, 2, 0, 3, 1, 0, 1, 0};

        Sort.bubbleSort(array);

        log.info("array:{}", array);
    }

    @Test
    public void testSelectionSort() {
        int[] array = generateArray();

        log.info("原数组：{}", array);

        Sort.selectionSort(array);

        log.info("选择排序后数组：{}", array);
    }

    /**
     * 快速排序测试用例
     * <p>
     * "D:\Program Files\Java\jdk1.8.0_301\bin\java.exe" -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:63121,suspend=y,server=n -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:C:\Users\Ryan\AppData\Local\JetBrains\IdeaIC2024.2\captureAgent\debugger-agent.jar -Dkotlinx.coroutines.debug.enable.creation.stack.trace=false -Ddebugger.agent.enable.coroutines=true -Dfile.encoding=UTF-8 -classpath "D:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.2.4\lib\idea_rt.jar;D:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.2.4\plugins\junit\lib\junit5-rt.jar;D:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.2.4\plugins\junit\lib\junit-rt.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\charsets.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\deploy.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\access-bridge-64.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\cldrdata.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\dnsns.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jaccess.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jfxrt.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\localedata.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\nashorn.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunec.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunjce_provider.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunmscapi.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunpkcs11.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\zipfs.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\javaws.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\jce.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\jfr.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\jfxswt.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\jsse.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\management-agent.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\plugin.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\resources.jar;D:\Program Files\Java\jdk1.8.0_301\jre\lib\rt.jar;D:\workplace\Code\demo\basic\target\test-classes;D:\workplace\Code\demo\basic\target\classes;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\boot\spring-boot-starter-json\2.3.2.RELEASE\spring-boot-starter-json-2.3.2.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\fasterxml\jackson\core\jackson-databind\2.11.1\jackson-databind-2.11.1.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\fasterxml\jackson\core\jackson-annotations\2.11.1\jackson-annotations-2.11.1.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\fasterxml\jackson\core\jackson-core\2.11.1\jackson-core-2.11.1.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.11.1\jackson-datatype-jdk8-2.11.1.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.11.1\jackson-datatype-jsr310-2.11.1.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.11.1\jackson-module-parameter-names-2.11.1.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\boot\spring-boot-starter-tomcat\2.3.2.RELEASE\spring-boot-starter-tomcat-2.3.2.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.37\tomcat-embed-core-9.0.37.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\glassfish\jakarta.el\3.0.3\jakarta.el-3.0.3.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.37\tomcat-embed-websocket-9.0.37.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-web\5.2.8.RELEASE\spring-web-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-beans\5.2.8.RELEASE\spring-beans-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-webmvc\5.2.8.RELEASE\spring-webmvc-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-aop\5.2.8.RELEASE\spring-aop-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-context\5.2.8.RELEASE\spring-context-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-expression\5.2.8.RELEASE\spring-expression-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\boot\spring-boot-starter\2.3.2.RELEASE\spring-boot-starter-2.3.2.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\boot\spring-boot\2.3.2.RELEASE\spring-boot-2.3.2.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\boot\spring-boot-autoconfigure\2.3.2.RELEASE\spring-boot-autoconfigure-2.3.2.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\boot\spring-boot-starter-logging\2.3.2.RELEASE\spring-boot-starter-logging-2.3.2.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;D:\software\install\maven\apache-maven-3.8.1\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\apache\logging\log4j\log4j-to-slf4j\2.13.3\log4j-to-slf4j-2.13.3.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\apache\logging\log4j\log4j-api\2.13.3\log4j-api-2.13.3.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;D:\software\install\maven\apache-maven-3.8.1\repository\jakarta\annotation\jakarta.annotation-api\1.3.5\jakarta.annotation-api-1.3.5.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-core\5.2.8.RELEASE\spring-core-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\springframework\spring-jcl\5.2.8.RELEASE\spring-jcl-5.2.8.RELEASE.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\yaml\snakeyaml\1.26\snakeyaml-1.26.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\projectlombok\lombok\1.18.16\lombok-1.18.16.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\alibaba\fastjson\1.2.28\fastjson-1.2.28.jar;D:\software\install\maven\apache-maven-3.8.1\repository\junit\junit\4.11\junit-4.11.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\apache\commons\commons-lang3\3.12.0\commons-lang3-3.12.0.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\google\guava\guava\33.0.0-jre\guava-33.0.0-jre.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\google\guava\failureaccess\1.0.2\failureaccess-1.0.2.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\google\guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\checkerframework\checker-qual\3.41.0\checker-qual-3.41.0.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\google\errorprone\error_prone_annotations\2.23.0\error_prone_annotations-2.23.0.jar;D:\software\install\maven\apache-maven-3.8.1\repository\com\google\j2objc\j2objc-annotations\2.8\j2objc-annotations-2.8.jar;D:\software\install\maven\apache-maven-3.8.1\repository\net\engio\mbassador\1.3.2\mbassador-1.3.2.jar;D:\software\install\maven\apache-maven-3.8.1\repository\cglib\cglib\3.3.0\cglib-3.3.0.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\ow2\asm\asm\7.1\asm-7.1.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\apache\velocity\velocity-engine-core\2.3\velocity-engine-core-2.3.jar;D:\software\install\maven\apache-maven-3.8.1\repository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 AlgorithmTest,testQuickSort
     * Connected to the target VM, address: '127.0.0.1:63121', transport: 'socket'
     * 16:12:05.578 [main] INFO AlgorithmTest - 原数组：[47, 11, 82, 95, 51, 61, 16, 23, 75, 33]
     * 16:30:12.754 [main] INFO AlgorithmTest - 快速排序后数组：[11, 16, 23, 33, 47, 51, 61, 75, 82, 95]
     * Disconnected from the target VM, address: '127.0.0.1:63121', transport: 'socket'
     * <p>
     * 18:03:25.081 [main] INFO AlgorithmTest - 原数组：[60, 99, 56, 18, 63, 59, 35, 36, 82, 42]
     * 18:03:25.081 [main] INFO com.zxw.demo.algorithm.Sort - 轴位置：3，left:0, right:9, 当前数组：[36, 35, 18, 42, 63, 59, 99, 60, 82, 56]
     * 18:03:25.081 [main] INFO com.zxw.demo.algorithm.Sort - 轴位置：0，left:0, right:2, 当前数组：[18, 35, 36, 42, 63, 59, 99, 60, 82, 56]
     * 18:03:25.081 [main] INFO com.zxw.demo.algorithm.Sort - 轴位置：1，left:1, right:2, 当前数组：[18, 35, 36, 42, 63, 59, 99, 60, 82, 56]
     * 18:03:25.081 [main] INFO com.zxw.demo.algorithm.Sort - 轴位置：4，left:4, right:9, 当前数组：[18, 35, 36, 42, 56, 59, 99, 60, 82, 63]
     * 18:03:25.081 [main] INFO com.zxw.demo.algorithm.Sort - 轴位置：7，left:5, right:9, 当前数组：[18, 35, 36, 42, 56, 59, 60, 63, 82, 99]
     * 18:03:25.081 [main] INFO com.zxw.demo.algorithm.Sort - 轴位置：5，left:5, right:6, 当前数组：[18, 35, 36, 42, 56, 59, 60, 63, 82, 99]
     * 18:03:25.081 [main] INFO com.zxw.demo.algorithm.Sort - 轴位置：8，left:8, right:9, 当前数组：[18, 35, 36, 42, 56, 59, 60, 63, 82, 99]
     * 18:03:25.081 [main] INFO AlgorithmTest - 快速排序后数组：[18, 35, 36, 42, 56, 59, 60, 63, 82, 99]
     */
    @Test
    public void testQuickSort() {
//        int[] array = generateArray();

        int[] array = new int[]{60, 99, 56, 18, 63, 59, 35, 36, 82, 42};

        log.info("原数组：{}", array);

        Sort.quickSort(array);
//        Sort.quickSort(array, 0, array.length - 1);

        log.info("快速排序后数组：{}", array);
    }

    @Test
    public void testDijkstra() {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra();
        log.info("dijkstra:{}", JSON.toJSONString(dijkstra));
    }

    /**
     * todo 这个有问题
     */
    @Test
    public void testDijkstraOptimized() {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstraOptimized();
        log.info("dijkstraOptimized:{}", JSON.toJSONString(dijkstra));
    }



    private int[] generateArray() {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

}
