package com.example.springboottest.generator;

// 可以单独引入一个静态方法

import tk.mybatis.mapper.generator.TkMyBatis3SimpleImpl;

import java.text.MessageFormat;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**
 * @Author: Ryan
 * @Date: 2024/12/25 15:26
 * @Version: 1.0
 * @Description: 自定义实现 mybatis3
 *                  暂不使用该类
 */
public class CustomMybatis3SimpleImpl extends TkMyBatis3SimpleImpl {

    @Override
    protected String calculateMyBatis3XmlMapperFileName() {
        StringBuilder sb = new StringBuilder();
        if (stringHasValue(tableConfiguration.getMapperName())) {
            String mapperName = tableConfiguration.getMapperName();
            int ind = mapperName.lastIndexOf(".");
            if (ind != -1) {
                mapperName = mapperName.substring(ind + 1);
            }
            // 支持 mapperName = "{0}Dao" 等用法
            sb.append(MessageFormat.format(mapperName, fullyQualifiedTable.getDomainObjectName()));
            sb.append(".xml"); // $NULL-NLS-1$
        } else {
            String xp = fullyQualifiedTable.getDomainObjectName();
            sb.append(xp);
            sb.append("Mapper.xml");
        }
        return sb.toString();
    }

    @Override
    protected void calculateJavaClientAttributes() {
        if (null == context.getJavaClientGeneratorConfiguration()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(calculateJavaClientImplementationPackage());
        sb.append(".");
        sb.append(fullyQualifiedTable.getDomainObjectName());
        sb.append("DaoImpl"); // $NULL-NLS-1$
        setDAOImplementationType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append(".");
        sb.append(fullyQualifiedTable.getDomainObjectName());
        sb.append("DAO"); // $NULL-NLS-1$
        setDAOInterfaceType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append(".");
        if (stringHasValue(tableConfiguration.getMapperName())) {
            // 支持 mapperName = "{0}Dao" 等用法
            sb.append(MessageFormat.format(tableConfiguration.getMapperName(),
                    fullyQualifiedTable.getDomainObjectName()));
        } else {
            String xp = fullyQualifiedTable.getDomainObjectName();
            sb.append(xp);
            sb.append("Mapper"); // $NULL-NLS-1$
        }
        setMyBatis3JavaMapperType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append(".");
        if (stringHasValue(tableConfiguration.getSqlProviderName())) {
            // 支持 mapperName = "{0}SqlProvider" 等用法
            sb.append(MessageFormat
                    .format(tableConfiguration.getSqlProviderName(), fullyQualifiedTable.getDomainObjectName()));
        } else {
            sb.append(tableConfiguration.getDomainObjectName());
            sb.append("SqlProvider");
        }
        setMyBatis3SqlProviderType(sb.toString());

    }
}
