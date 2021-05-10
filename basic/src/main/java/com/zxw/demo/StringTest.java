package com.zxw.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2020/11/16 21:38
 * @Version: 1.0
 * @Description:
 */
public class StringTest {

    /**
     * 截取符号之后的字符串
     * @param args
     */
//    public static void main(String[] args) {
////        String code = "code_18723605266";
////        String substring = code.substring(code.indexOf("_") + 1);
////        System.out.println(substring);
////    }

    /**
     * 替换 html 标签
     */
//    public static void main(String[] args) {
//        String content = "div/p/img/ul/li/span";
////        String replace = content.replace("img", "image");
////        System.out.println(replace);
////        String rep = replace.replace("div|p|ul|li|span", "view");
////        System.out.println(rep);
////        String repl = replace.replace("div", "view").replace("p", "view").replace("ul", "view")
////                .replace("li", "view").replace("span", "text");
////        System.out.println(repl);
//        String view = content.replaceAll("(?:div|span|ul|li)", "view");
//        System.out.println(view);
//
//        String label = "<div></div>";
//        String s = label.replaceAll("(?:div>)", "view>");
//        System.out.println(s);
//    }

    /**
     * 找到字符串某个字符的最后一位的下标值
     *
     * @param args
     */
//    public static void main(String[] args) {
//        String url = "/aaa/bbb/ccc";
//        int i = url.lastIndexOf("/");
//        String newUrl = url.substring(0,i);
//        System.out.println(newUrl);
//    }

    /**
     * json 字符串转成 map
     * @param args
     */
//    public static void main(String[] args) {
//        String jsonStr = "{\n" +
//                "\t\"title\":\"关于我们\",\n" +
//                "    \"logo\":\"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.16pic.com%2F00%2F01%2F44%2F16pic_144000_b.jpg&refer=http%3A%2F%2Fpic1.16pic.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612424023&t=754392de19b50eaabb8dc00d92dfb329\",\n" +
//                "    \"name\":\"吃喝玩乐\",\n" +
//                "    \"weChatOfficialAccount\":\"cqshua\",\n" +
//                "    \"companyWebsite\":\"http://www.ssccc.cn\",\n" +
//                "    \"customerServiceTel\":\"023-45652355\",\n" +
//                "    \"e-mail\":\"18883888097@139.com\"\n" +
//                "}";
//        Object parse = JSONObject.parse(jsonStr);
//        System.out.println(parse);
//        Map map = JSONObject.parseObject(jsonStr, Map.class);
//        System.out.println(map);
//        System.out.println(map.get("name"));
//    }

    /**
     * map 转 json 字符串
     * @param args
     */
//    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "ryan");
//        map.put("age", 20);
//        String string = JSONObject.toJSONString(map);
//        System.out.println(string);
//    }

    /**
     * 截取文件名（不带格式）
     * @param args
     */
//    public static void main(String[] args) {
//        String str = "54646.png";
//        String substring = str.substring(0, str.indexOf("."));
//        System.out.println(substring);
//    }

    /**
     * 截取 第六位 到最后的
     * @param args
     */
//    public static void main(String[] args) {
//        String phone = "18723605266";
//        String substring = phone.substring(6);
//        System.out.println(substring);
//    }

    /**
     * 分割
     */
    public static void main(String[] args) {

        String url = "/aaa/bbb/ccc";
        int i = url.lastIndexOf("/");
        String newUrl = url.substring(0, i);
        System.out.println(newUrl);

        String amount = "0.1";
        String a = "数量大幅改良.鞍山酒店开房间";
        String[] split = amount.split("\\.");
        System.out.println(Arrays.toString(split));
        String[] strings = a.split("\\.");
        System.out.println(Arrays.toString(strings));
    }

    /**
     * 截取字符串
     * @param args
     */
//    public static void main(String[] args) {
//        String url = "src=http___pic.51yuansu.com_backgd_cover_00_37_82_5be024976ca74.jpg!_fw_780_quality_90_unsharp_true_compress_true&refer=http___pic.51yuansu.jpg";
//        String substring = url.substring(0, url.lastIndexOf("."));
//        System.out.println(substring);
//    }

//
//    public static void main(String[] args) {
//        String str = "str";
//        String s = null;
//        boolean equals = str.equals(s);
//        System.out.println(equals);
//    }
}
