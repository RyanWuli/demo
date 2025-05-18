package work.basic;

import com.google.common.collect.Maps;
import com.zxw_work.biz.MyBiz;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2024/11/5 16:21
 * @Version: 1.0
 * @Description: 反射测试类
 */
@Slf4j
public class ReflectTest {

    @Test
    public void TestCollectObjectsFromPackage() throws IOException, ClassNotFoundException {
        String name = MyBiz.class.getPackage().getName();
        log.info("packageName:{}", name);

        String packegePath = name.replace(".", "/");

        Map<String, Class> classMap = Maps.newHashMap();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        Enumeration<URL> enumeration = contextClassLoader.getResources(packegePath);
        log.info("enumeration:{}", enumeration);

        boolean hasMoreElements = enumeration.hasMoreElements();
        log.info("hasMoreElements:{}", hasMoreElements);

        if (!hasMoreElements) {
            log.info("{}包不存在，请检查...", name);
            return;
        }

        // 资源定位符
        URL url = enumeration.nextElement();
        String file = url.getFile();
        // 包所对应的文件夹
        File directory = new File(file);

        if (!directory.exists()) {
            log.info("{}包文件夹不存在...", name);
            return;
        }

        File[] files = directory.listFiles();

        if (ArrayUtils.isEmpty(files)) {
            log.info("{}包文件为空...", name);
            return;
        }

        // 遍历加载类
        for (File f : files) {
            String fileName = f.getName();
            if (!fileName.endsWith(".class")) {
                log.info("当前文件不是 class 文件，文件名：{}", fileName);
                continue;
            }

            String className = fileName.replace(".class", "");
            String fullClassName = name + "." + className;

            Class<?> aClass = contextClassLoader.loadClass(fullClassName);

            classMap.put(fullClassName, aClass);
        }

        log.info("classMap:{}", classMap);
    }

}
