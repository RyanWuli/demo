package com.example.springboottest.generator;

import org.mybatis.generator.config.*;
import org.springframework.util.Assert;

/**
 * @Author: Ryan
 * @Date: 2024/12/25 14:38
 * @Version: 1.0
 * @Description: 根据 table 生成 do 对象，适合数据驱动开发方式
 *                  暂不使用该类
 */
public class Generator {















    private String database;
    private String username;
    private String password;
    private Context context;
    private PluginConfiguration pluginConfiguration;
    private JDBCConnectionConfiguration jdbcConnectionConfiguration;
    private JavaModelGeneratorConfiguration javaModelGeneratorConfiguration;
    private JavaClientGeneratorConfiguration javaClientGeneratorConfiguration;
    private SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration;













    public Generator(String database, String ip, String port, String username, String password) {
        this.database = database;
        this.username = username;
        this.password = password;

        Assert.hasLength(database, "数据库名称不能为空");
        Assert.hasLength(ip, "ip 不能为空");

        String jdbcUrl = "jdbc:mysql://" + ip + ":" + port + "/" + database
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF8";


        context = new Context(ModelType.FLAT);
        context.setId("mysql");
        context.setTargetRuntime("com.example.springboottest.generator.CustomMybatis3SimpleImpl");
        context.addProperty("javaFileEncoding", "UTF-8");
        context.addProperty("useMapperCommentGenerator", "true");
        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("javaFileEncoding", "UTF-8");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

        this.pluginConfiguration = new PluginConfiguration();
//        this.pluginConfiguration.setConfigurationType(ge);
    }


}
