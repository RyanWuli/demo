package com.example.springboottest.generator;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.internal.util.StringUtility;
import tk.mybatis.mapper.generator.MapperPlugin;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ryan
 * @Date: 2024/12/25 18:42
 * @Version: 1.0
 * @Description: 生成插件实现类
 *                  该类暂不使用
 */
public class GenPlugin extends MapperPlugin {

    private Set<String> mappers = new HashSet<>();
    private boolean caseSensitive = false;
    private boolean useMapperCommentGenerator = true;
    // 开始的分隔符，例如 mysql 为 `, sqlServer 为 [
    private String benginningDelimiter = "";
    // 结束的分隔符，例如 mysql 为 `, sqlServer 为 [
    private String endingDelimiter = "";
    // 数据库模式
    private String schema;
    // 注释生成器
    private CommentGeneratorConfiguration commentCfg;
    // 强制生成注解
    private boolean foreAnnotation = false;
    // 是否生成 Data 注解
    private boolean needsData = false;
    // 是否生成 Getter 注解
    private boolean needsGetter = false;
    // 是否生成 Setter 注解
    private boolean needsSetter = false;
    // 是否生成 ToString 注解
    private boolean needsToString = false;
    // 是否生成 Accessors(chain = true) 注解
    private boolean needsAccessors = false;
    // 是否生成 EqualsAndHashCode 注解
    private boolean needsEqualsAndHashCode = false;
    // 是否生成默认属性静态方法
    private boolean generateDefaultInstanceMethod = false;
    // 是否生成 swagger 注解（包括 @ApiModel、@ApiModelProperty）
    private boolean needsSwagger = false;

    public String getDelimiterName(String name) {
        StringBuilder nameBuilder = new StringBuilder();
        if (StringUtility.stringHasValue(schema)) {
            nameBuilder.append(schema);
            nameBuilder.append(".");
        }

        nameBuilder.append(benginningDelimiter);
        nameBuilder.append(name);
        nameBuilder.append(endingDelimiter);
        return nameBuilder.toString();
    }

    /**
     * 生成的 mapper 接口
     */
    public boolean clientGenerated(
            Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        // 获取实体类
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

        // import 接口
        for (String mapper : mappers) {
            interfaze.addImportedType(new FullyQualifiedJavaType(mapper));
            interfaze.addImportedType(new FullyQualifiedJavaType(Mapper.class.getName()));
            interfaze.addAnnotation("@Mapper");
            interfaze.addSuperInterface(
                    new FullyQualifiedJavaType(mapper + "<" + entityType.getShortName() + ">"));
            // import 实体类
            interfaze.addImportedType(entityType);
        }

        return true;
    }

    public void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

    }

}
