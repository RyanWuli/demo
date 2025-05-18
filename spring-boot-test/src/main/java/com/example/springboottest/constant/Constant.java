package com.example.springboottest.constant;

/**
 * @Author: Ryan
 * @Date: 2024/12/16 14:45
 * @Version: 1.0
 * @Description: 通用常量
 */
public class Constant {

    public static final String AND = "&";

    public static final String QUES = "?";

    public static final String EQ = "=";

    /**
     * 全局流水号 key
     */
    public static final String ORDER_NO = "orderNo";


    /**
     * 动态数据源相关常量
     */
    public static class DynamicDatasource {
        /**
         * 备库数据源名称
         */
        public static final String SLAVE = "slave";

        /**
         * 默认数据源名称
         */
        public static final String DEFAULT_DATASOURCE = "defaultDatasource";

        /**
         * 动态数据源名称
         */
        public static final String DYNAMIC_DATASOURCE = "defaultDatasource";
    }

}
