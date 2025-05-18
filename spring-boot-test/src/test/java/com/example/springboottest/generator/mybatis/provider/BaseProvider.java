//package com.example.springboottest.generator.mybatis.provider;
//
//import org.apache.ibatis.mapping.MappedStatement;
//import tk.mybatis.mapper.mapperhelper.EntityHelper;
//import tk.mybatis.mapper.mapperhelper.MapperHelper;
//import tk.mybatis.mapper.mapperhelper.MapperTemplate;
//import tk.mybatis.mapper.util.MsUtil;
//
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//
///**
// * @Author: Ryan
// * @Date: 2024/12/27 10:15
// * @Version: 1.0
// * @Description: add the description
// */
//public class BaseProvider extends MapperTemplate {
//
//    public BaseProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
//        super(mapperClass, mapperHelper);
//    }
//
//    public Class<?> getEntityClass(MappedStatement ms) {
//        String msId = ms.getId();
//        if (entityClassMap.containsKey(msId)) {
//            return entityClassMap.get(msId);
//        }
//        Class<?> mapperClass = MsUtil.getMapperClass(msId);
//        Type[] types = mapperClass.getGenericInterfaces();
//        for (Type type : types) {
//            if (type instanceof ParameterizedType) {
//                ParameterizedType t = (ParameterizedType) type;
//                if (t.getRawType() == this.mapperClass
//                        || this.mapperClass.isAssignableFrom((Class<?>) t.getRawType())) {
//
//                    Class<?> retrunType = (Class<?>) t.getActualTypeArguments()[0];
//                    Class<?> ts = retrunType;
//                    while (ts != null && (!ts.isInterface() || !ts.isAssignableFrom(Object.class))) {
//                        // 获取该类型后，第一次对该类型进行初始化
//                        EntityHelper.initEntityNameMap(ts, mapperHelper.getConfig());
//                        ts = ts.getSuperclass();
//                    }
//                    entityClassMap.put(msId, retrunType);
//                    return retrunType;
//                }
//            }
//        }
//        throw new RuntimeException("无法获取" + msId + "方法的泛型信息!");
//    }
//}
