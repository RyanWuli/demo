package com.zxw_home.enumsingleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by Ryan on 2022/8/24 11:30
 * Version 1.0
 * Description explain
 */
public class Entity {

    public final Map<String, String> params = new HashMap<>();

    public Entity() {
        params.put("name", "Ryan");
    }
}
