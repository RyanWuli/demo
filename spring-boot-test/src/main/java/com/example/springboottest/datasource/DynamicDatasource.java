package com.example.springboottest.datasource;

import com.example.springboottest.constant.Constant;
import com.example.springboottest.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2024/12/16 15:55
 * @Version: 1.0
 * @Description: 动态数据源自动切换类
 */
@Slf4j
public class DynamicDatasource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> datasourceKey = ThreadLocal
            .withInitial(() -> Constant.DynamicDatasource.DEFAULT_DATASOURCE);

    private static final Map<Object, Object> datasourceMap = new HashMap<>(8);

    static {
        datasourceMap.put(Constant.DynamicDatasource.DEFAULT_DATASOURCE,
                SpringUtil.getBean(Constant.DynamicDatasource.DEFAULT_DATASOURCE));
        datasourceMap.put(Constant.DynamicDatasource.SLAVE, SpringUtil.getBean(Constant.DynamicDatasource.SLAVE));
    }

    public DynamicDatasource() {
        setTargetDataSources(datasourceMap);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return datasourceKey.get();
    }

    /**
     * 设置数据源
     */
    public static void setDatasource(String datasource) {
        datasourceKey.set(datasource);
        DynamicDatasource dynamicDatasource = SpringUtil.getBean(Constant.DynamicDatasource.DYNAMIC_DATASOURCE);
        dynamicDatasource.setTargetDataSources(SpringUtil.getBean(Constant.DynamicDatasource.DEFAULT_DATASOURCE));
        dynamicDatasource.afterPropertiesSet();
    }

    /**
     * 获取数据源名称
     */
    public static String getDatasource() {
        return datasourceKey.get();
    }

    /**
     * 清空当前数据源
     */
    public static void clear() {
        log.info("清空当前数据源：{}", datasourceKey.get());
        datasourceKey.remove();
    }

    /**
     * 切换数据源
     */
    public static void changeDatasource(String datasource) {
        log.info("切换到数据源：{}", datasource);
        if (null == datasourceMap.get(datasource)) {
            throw new RuntimeException(String.format("未找到指定数据源：%s", datasource));
        }
        setDatasource(datasource);
    }

}
