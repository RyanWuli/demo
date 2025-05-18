//package com.example.springboottest.generator.mybatis.provider;
//
//import org.apache.ibatis.mapping.MappedStatement;
//import tk.mybatis.mapper.mapperhelper.MapperHelper;
//import tk.mybatis.mapper.mapperhelper.SqlHelper;
//
///**
// * @Author: Ryan
// * @Date: 2024/12/27 13:45
// * @Version: 1.0
// * @Description: add the description
// */
//public class MySelectProvider extends BaseProvider {
//
//    public static final String M_SELECT_BY_ID = "selectById";
//
//    public MySelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
//        super(mapperClass, mapperHelper);
//    }
//
//    public String selectById(MappedStatement ms) {
//        final Class<?> entityClass = getEntityClass(ms);
//        // 将返回值类型改为实体类型
//        setResultType(ms, entityClass);
//        StringBuilder sql = new StringBuilder();
//        sql.append(SqlHelper.selectAllColumns(entityClass));
//        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
//        sql.append(SqlHelper.wherePKColumns(entityClass));
//        return sql.toString();
//    }
//}
