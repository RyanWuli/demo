package com.zxw_work.biz;

import com.zxw_work.entity.*;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.cglib.beans.BeanMap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @Author: Ryan
 * @Date: 2024/9/6 9:46
 * @Version: 1.0
 * @Description: 业务可能用到的
 */
public class Biz {

    private static Random random = new Random();

    /**
     * 唯一 code 生成(18 位)
     * <p>
     * random.nextInt(100000) 只是模拟数字，需要利用数据库（insert on dup update）等实现自增且不重复
     * 支持每天生成最多 99999999999 个 code，更多可以扩展位数
     */
    public static String getUniqueCode() {
        String yyyyMMdd = FastDateFormat.getInstance("yyyyMMdd").format(new Date());

        // 7位16进制，至少说 1970-2999 年，只会是7位
        String yyyyMMddHex = Integer.toHexString(Integer.parseInt(yyyyMMdd));

        // 7位(16进制) + 11位(序号，如:00000000001)
        return yyyyMMddHex + String.format("%011d", random.nextInt(100000));
    }

    /**
     * 动态模板引擎 string 替换
     *
     * @param template 原模板
     * @param replaceMap 需要替换的数据
     * @return 替换后的内容
     */
    public static String templateReplace(String template, Map<String, Object> replaceMap) {
        VelocityContext vc = new VelocityContext(replaceMap);

        StringWriter sw = new StringWriter();

        Velocity.evaluate(vc, sw, "vc_template", template);

        return sw.toString();
    }

    /**
     * 生成 converter 类
     * @param param
     */
    public static void generateConverter(ConverterGenerateParam param) throws IOException {
        InputStream is = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {

            // 1.获取模板文件
            // - 获取文件输入流
            // - ClassLoader.getSystemResourceAsStream("template/ClassTemplate.vm"); 获取系统 java 或 resources 下的文件
            is = ClassLoader.getSystemResourceAsStream("template/ClassTemplate.vm");
            // - 构建字符读 buffer
            assert is != null;
            reader = new BufferedReader(new InputStreamReader(is));

            // 2.将模板文件读为字符串
            // - 每行读取字符串
            String line;
            // - 读取的数据
            StringBuilder data = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }

            // 3.将字符串进行动态替换值
            String newFileStr = templateReplace(data.toString(), BeanMap.create(param));

            // 4.将字符串写入文件
            // - 生成文件位置
            String outPath = "D:\\workplace\\Code\\demo\\basic\\src\\main\\java\\com\\zxw_work\\entity\\out";
            String outName = outPath + "\\" + param.getFileName() + ".java";
            // 这一步不会生成文件
            File outFile = new File(outName);
            if (!outFile.exists()) {
                // 这一步会生成文件
                outFile.createNewFile();
            }
            Path path = Paths.get(outFile.getAbsolutePath());
            writer = Files.newBufferedWriter(path);
            writer.write(newFileStr);

        } finally {
            if (null != is) {
                is.close();
            }
            if (null != reader) {
                reader.close();
            }
            if (null != writer) {
                writer.close();
            }
        }

    }

    /**
     * 构建转换参数
     */
    public static ConverterGenerateParam buildParam() {
        ConverterGenerateParam param = new ConverterGenerateParam();
        param.setEntityName(Entity02.class.getSimpleName());
        param.setEntityFullName(Entity02.class.getName());
        param.setEreqName(Ereq02.class.getSimpleName());
        param.setEreqFullName(Ereq02.class.getName());
        param.setEresName(Eres02.class.getSimpleName());
        param.setEresFullName(Eres02.class.getName());
        param.setFileName("Converter02");
        param.setMethodName("用户查询");
        param.setReqName(Req02.class.getSimpleName());
        param.setReqFullName(Req02.class.getName());
        param.setResName(Res02.class.getSimpleName());
        param.setResFullName(Res02.class.getName());
        param.setServiceDesc("模拟的用户查询接口构建转换器");
        param.setServiceName("userQuery");
        param.setServiceSeqNo("10000001");
        param.setPackageName("com.zxw_work.entity.out");
        return param;
    }

}
