package com.example.springboottest.generator.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;
import tk.mybatis.mapper.generator.MapperPlugin;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: Ryan
 * @Date: 2024/12/26 16:40
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class MyGenPlugin extends MapperPlugin {

    private Set<String> mappers = new HashSet();

//    @Override
//    public boolean validate(List<String> list) {
//        return true;
//    }
//
//    @Override
//    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        topLevelClass.addImportedType("javax.persistence.Column");
//        topLevelClass.addImportedType("javax.persistence.Table");
//        topLevelClass.addImportedType("javax.persistence.Id");
//
//        topLevelClass.addImportedType("lombok.Getter");
//        topLevelClass.addImportedType("lombok.Setter");
//        topLevelClass.addImportedType("lombok.ToString");
//        topLevelClass.addAnnotation("@Getter");
//        topLevelClass.addAnnotation("@Setter");
//        topLevelClass.addAnnotation("@ToString");
//
//        topLevelClass.addAnnotation("@Table(name = \"`" + introspectedTable.getFullyQualifiedTable() + "`\")");
//
//        log.info("tableConfiguration:{}", JSON.toJSONString(introspectedTable.getTableConfiguration()));
//
//        if (StringUtils.isNoneBlank(introspectedTable.getTableConfiguration().getDomainObjectName())) {
//            topLevelClass.addImportedType("org.apache.ibatis.type.Alias");
//            topLevelClass.addAnnotation("@Alias(\""
//                    + toLowerCaseFirstOne(introspectedTable.getTableConfiguration().getDomainObjectName()) + "\")");
//        }
//
//        return true;
//
//    }
//
//    @Override
//    public boolean modelFieldGenerated(Field field,
//                                       TopLevelClass topLevelClass,
//                                       IntrospectedColumn introspectedColumn,
//                                       IntrospectedTable introspectedTable,
//                                       ModelClassType modelClassType) {
//
//        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
//
//        for (IntrospectedColumn col : primaryKeyColumns) {
//            if (StringUtils.equals(col.getActualColumnName(), introspectedColumn.getActualColumnName())) {
//                field.addJavaDocLine("@Id");
//            }
//        }
//
//        field.addJavaDocLine("@Column(name = \"`" + introspectedColumn.getActualColumnName() + "`\")");
//
//        return true;
//    }

    /**
     * java do 对象是否生成 getter 方法
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {

        return false;
    }

    /**
     * java do 对象是否生成 setter 方法
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }
//
//    @Override
//    public boolean providerGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        log.info("providerGenerated config:{}", introspectedTable.getTableConfiguration());
//
//        topLevelClass.addImportedType("com.example.springboottest.entity.UserVo");
//
//        return true;
//
//    }
//
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
//
//    @Override
//    public boolean sqlMapResultMapWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapSelectAllElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapResultMapWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapBlobColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientCountByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientDeleteByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientInsertMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientSelectAllMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    /**
//     * 這個控制是否生成 mapper 接口
//     *
//     * client 相关的是 mapper 接口
//     */
//    @Override
//    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
////        topLevelClass.addImportedType("org.apache.ibatis.annotations.Mapper");
////        topLevelClass.addImportedType("com.example.springboottest.generator.mybatis.base.BaseMapper");
////        topLevelClass.setSuperClass("BaseMapper");
////        topLevelClass.addAnnotation("@Mapper");
//
//        String baseRecordTypeStr = introspectedTable.getBaseRecordType();
//
//        FullyQualifiedJavaType mapperType = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");
//        FullyQualifiedJavaType baseMapperType = new FullyQualifiedJavaType("com.example.springboottest.generator.mybatis.base.BaseMapper");
////        interfaze.addImportedType(baseMapperType);
//        FullyQualifiedJavaType baseRecordType = new FullyQualifiedJavaType(baseRecordTypeStr);
////        interfaze.addImportedType(baseRecordType);
//        baseMapperType.addTypeArgument(baseRecordType);
//        interfaze.addSuperInterface(baseMapperType);
//        interfaze.addAnnotation("@Mapper");
////        interfaze.addImportedType(mapperType);
//
//        Set<FullyQualifiedJavaType> typeSet = new HashSet<>();
//        typeSet.add(mapperType);
//        typeSet.add(baseMapperType);
//        typeSet.add(baseRecordType);
//        interfaze.addImportedTypes(typeSet);
//
//        return true;
//    }
//
//    @Override
//    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerApplyWhereMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerCountByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerDeleteByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerUpdateByExampleSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerUpdateByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerUpdateByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean providerUpdateByPrimaryKeySelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
//    @Override
//    public boolean clientInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        return false;
//    }
//
////    @Override
////    public void initialized(IntrospectedTable introspectedTable) {
////        super.initialized(introspectedTable);
////    }
////
//


    /**
     * 这个方法操作 mapper 接口
     */
    @Override
    public boolean clientGenerated(Interface interfaze,
                                   TopLevelClass topLevelClass,
                                   IntrospectedTable introspectedTable) {

        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        interfaze.addImportedType(entityType);

        for (String mapper : this.mappers) {
            interfaze.addImportedType(new FullyQualifiedJavaType(mapper));
            interfaze.addImportedType(new FullyQualifiedJavaType(Mapper.class.getName()));
            interfaze.addAnnotation("@Mapper");
            interfaze.addSuperInterface(
                    new FullyQualifiedJavaType(mapper + "<" + entityType.getShortName() + ">"));
        }
        return true;
    }

    /**
     * 此方法操作对象 do 类
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);

//        topLevelClass.addImportedType("javax.persistence.Column");
//        topLevelClass.addImportedType("javax.persistence.Table");
//        topLevelClass.addImportedType("javax.persistence.Id");

        topLevelClass.addImportedType("lombok.Getter");
        topLevelClass.addImportedType("lombok.Setter");
        topLevelClass.addImportedType("lombok.ToString");
        topLevelClass.addAnnotation("@Getter");
        topLevelClass.addAnnotation("@Setter");
        topLevelClass.addAnnotation("@ToString");

//        topLevelClass.addAnnotation("@Table(name = \"`" + introspectedTable.getFullyQualifiedTable() + "`\")");
//
//        log.info("tableConfiguration:{}", JSON.toJSONString(introspectedTable.getTableConfiguration()));

        if (StringUtils.isNoneBlank(introspectedTable.getTableConfiguration().getDomainObjectName())) {
            topLevelClass.addImportedType("org.apache.ibatis.type.Alias");
            topLevelClass.addAnnotation("@Alias(\""
                    + toLowerCaseFirstOne(introspectedTable.getTableConfiguration().getDomainObjectName()) + "\")");
        }

        return true;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);

        String mappers = properties.getProperty("mappers");

        if (StringUtility.stringHasValue(mappers)) {
            for (String mapper : mappers.split(",")) {
                this.mappers.add(mapper);
            }
        }
    }
}
