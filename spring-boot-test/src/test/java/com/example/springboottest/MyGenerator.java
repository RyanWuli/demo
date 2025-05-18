package com.example.springboottest;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.ShellRunner;

/**
 * @Author: Ryan
 * @Date: 2024/12/24 18:56
 * @Version: 1.0
 * @Description: mybatis 代码生成器
 */
@Slf4j
public class MyGenerator {

//    public void generator() throws Exception {
//        List<String> warnings = new ArrayList<>();
//        boolean overWrite = true;
//        // 逆向生成配置
//        ClassPathResource resource = new ClassPathResource("generatorConfig.xml");
//        File configFile = resource.getFile();
////        File configFile = new File("generatorConfig.xml");
//        ConfigurationParser parser = new ConfigurationParser(warnings);
//        Configuration config = parser.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overWrite);
//        MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
//        generator.generate(null);
//
//        if (CollectionUtil.isNotEmpty(warnings)) {
//            warnings.forEach(System.out::println);
//        }
//    }
//
//    public static void main(String[] args) {
//        MyGenerator myGenerator = new MyGenerator();
//        try {
//            myGenerator.generator();
//        } catch (Exception e) {
//            log.error("mybatis generator error, ", e);
//        }
//    }

    /**
     * 这种是简化的生成器启动方式，和上面都是一样的功能
     */
    public static void main(String[] args) {
        args = new String[]{"-configfile",
                "D:\\workplace\\Code\\demo\\spring-boot-test\\src\\main\\resources\\generatorConfig.xml", "-overwrite"};
        ShellRunner.main(args);
    }

}
