package com.zxw.demo;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by IntelliJ IDEA.
 *
 * @User: UI
 * @Date: 2020/7/31
 * @Time: 9:11
 * @Version: 1.0
 * @Description: 复制 dat 文件并修改格式 png
 */
public class FormatConversion {

    public static void main(String[] args) {
        String oldP = "X:\\Users\\UI\\AppData\\Roaming\\360safe\\DesktopRest\\eye\\bk_image"; // 原文件夹
        String newP = "X:\\Users\\UI\\Desktop\\bizhi"; // 复制到的新文件夹
        copyDir(oldP, newP);
    }

    /**
     * 文件夹的拷贝
     */
    public static void copyDir(String oldPath, String newPath) {
        File oldF = new File(oldPath);
        File newF = new File(newPath);
        String[] files = oldF.list(); // 获取文件夹下的所有文件和文件名称
        if (!newF.exists()) {
            newF.mkdir();
        }
        boolean flag = false;
        for (String s : files) {
            String oldFullPath = oldPath + File.separator + s;
            System.out.println(oldFullPath);
            String replaceS = s.replace("dat", "png");
            String newFullPath = newPath + File.separator + replaceS; // File.separator 分隔符
            System.out.println(newFullPath);
            long l = copyFile(oldFullPath, newFullPath);
            if (l == 0) {
                System.out.println("复制出错了(┬＿┬)");
            } else {
                System.out.println("复制成功了╰(￣▽￣)╮");
            }
        }
    }

    public static long copyFile(String oldFileStr, String newFileStr) {
        boolean flag = false;
        FileChannel input = null;
        FileChannel output = null;
        long l = 0;
        try {
            input = new FileInputStream(oldFileStr).getChannel();
            output = new FileOutputStream(newFileStr).getChannel();
            l = output.transferFrom(input, 0, input.size());
        } catch (IOException e) {
            System.out.println("复制失败了！(｡•ˇ‸ˇ•｡)");
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return l;
    }
}
