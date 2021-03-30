package com.zxw.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/1/27 10:21
 * @Version: 1.0
 * @Description:
 */
public class JsonTest {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("https://www.baidu.com");
        strList.add("https://www.taobao.com");
        System.out.println(">>>>> strList=" + strList);
        String jsonString = JSONObject.toJSONString(strList);
        System.out.println(">>>>> jsonString=" + jsonString);
        JSONArray jsonArray = JSONObject.parseArray(jsonString);
        System.out.println(">>>>> parseStr=" + jsonArray);

        // 转 json string 转 list
        List<String> lists = JSONObject.parseArray(jsonString, String.class);
        System.out.println(">>>>> lists=" + lists);
    }
}
