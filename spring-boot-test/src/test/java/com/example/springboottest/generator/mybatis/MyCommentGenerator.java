package com.example.springboottest.generator.mybatis;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Author: Ryan
 * @Date: 2024/12/26 11:24
 * @Version: 1.0
 * @Description: 自定义注解生成
 *                  此类主要是做注解相关的操作
 */
public class MyCommentGenerator extends DefaultCommentGenerator {

    private Properties properties;
    private Properties systemPro;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;

    public MyCommentGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {

        // 不生成注释
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString());
//        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine(" */");

//        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
//
//        for (IntrospectedColumn col : primaryKeyColumns) {
//            if (StringUtils.equals(col.getActualColumnName(), introspectedColumn.getActualColumnName())) {
//                field.addJavaDocLine("@Id");
//            }
//        }
//
//        field.addJavaDocLine("@Column(name = \"`" + introspectedColumn.getActualColumnName() + "\"`)");

    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        suppressDate = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        suppressAllComments = StringUtility
                .isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

    @Override
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append("do not delete during merge");
        }
        String s = getDateString();
        if (s != null) {
            sb.append(" ");
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    @Override
    protected String getDateString() {
        String result = null;
        if (!suppressDate) {
            result = currentDateStr;
        }
        return result;
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" ");
        sb.append(getDateString());
        innerClass.addJavaDocLine(sb.toString());
        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());
        innerEnum.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

        if (suppressAllComments) {
            return;
        }

        method.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());


        sb.setLength(0);
        sb.append(" * @return ");
        // 这里只能拿到表字段名称
        sb.append(introspectedColumn.getActualColumnName());
        sb.append(" ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");

    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

        method.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());

        Parameter param = method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param ");
        sb.append(param.getName());
        sb.append(" ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");

    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        topLevelClass.addImportedType("javax.persistence.Column");
//        topLevelClass.addImportedType("javax.persistence.Table");
//        topLevelClass.addImportedType("javax.persistence.Id");
//        topLevelClass.addImportedType("org.apache.ibatis.type.Alias");
//        topLevelClass.addImportedType("lombok.Getter");
//        topLevelClass.addImportedType("lombok.Setter");
//        topLevelClass.addImportedType("lombok.ToString");

        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        topLevelClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" 表 Do");
        topLevelClass.addJavaDocLine(sb.toString());

        sb.setLength(0);
        sb.append(" * @author ");
        String userName = systemPro.getProperty("user.name");
        userName = StringUtils.isBlank(userName) ? "generator" : userName;
        sb.append(userName);
        sb.append("\n");
        sb.append(" * @date ");
        sb.append(currentDateStr);
        topLevelClass.addJavaDocLine(sb.toString());

        topLevelClass.addJavaDocLine(" */");
//        topLevelClass.addAnnotation("@Table(name = \"`" + introspectedTable.getFullyQualifiedTable() + "\"`)");
//        topLevelClass.addAnnotation("@Alias(\""
//                + toLowerCaseFirstOne(introspectedTable.getTableConfiguration().getDomainObjectName()) + "\")");
    }

    /**
     * 首字母转小写
     */
    public static String toLowerCaseFirstOne(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }

        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        }

        return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }



}

