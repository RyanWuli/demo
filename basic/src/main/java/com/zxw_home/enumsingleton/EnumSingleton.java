package com.zxw_home.enumsingleton;

import java.awt.image.VolatileImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by Ryan on 2022/8/24 11:07
 * Version 1.0
 * Description 枚举单例模式应用
 */
public enum EnumSingleton {

    INSTANCE;

    public final Map<String, String> params = new HashMap<>();

    EnumSingleton() {
        params.put("name", "ryan");
    }
}
