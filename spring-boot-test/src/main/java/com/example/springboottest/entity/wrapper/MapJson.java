package com.example.springboottest.entity.wrapper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 15:54
 * @Version: 1.0
 * @Description: 数据库 varchar 存 json 数据对应的类型
 */
public class MapJson<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 3387019496416611354L;

    public MapJson() {}

    public MapJson(Map<K, V> map) {
        if (null != map) {
            this.putAll(map);
        }
    }
}
