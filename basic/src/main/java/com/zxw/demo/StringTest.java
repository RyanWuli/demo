package com.zxw.demo;

import java.util.Date;

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
     * @param args
     */
    public static void main(String[] args) {
        String url = "/aaa/bbb/ccc";
        int i = url.lastIndexOf("/");
        String newUrl = url.substring(0,i);
        System.out.println(newUrl);
    }

}
