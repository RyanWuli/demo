package com.zxw.demo;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.rmi.server.ExportException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by Ryan on 2021/1/18 0:35
 * Version 1.0
 * Description 最开始的位置：C:\Users\Ray\AppData\Roaming\360safe\DesktopRest\eye\bk_image
 */
public class CopyImages {

    public static void main(String[] args) {

        // 不存在文件夹则创建，每次以每天的年月日当文件夹名称
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(date);
        File fileDir = new File("C:\\Users\\Ray\\AppData\\Roaming\\360browser\\bkinfo");
        String path = "E:\\壁纸\\360\\wallpaper" + format;
        File toDir = new File(path);
        if (!toDir.exists()) toDir.mkdirs();

        // 判断是否文件夹
        if (fileDir.isDirectory()) {
            File[] files = fileDir.listFiles();
            if (files == null) return;
            for (File file : files) {
                if (file.isDirectory()) {
                    continue;
                }
                String oldName = file.getName();
                String newName = "";
                if (oldName.contains("dat")) {
                    newName = oldName.replace("dat", "jpg");
                } else {
                    newName = oldName + ".jpg";
                }
                int bytesum = 0;
                int byteread = 0;
                try {
                    InputStream inputStream = new FileInputStream(file);
                    OutputStream outputStream = new FileOutputStream(toDir + "\\" + newName);
                    byte[] b = new byte[1024];
//                    int length;
                    while ((byteread = inputStream.read(b)) != -1) {
                        outputStream.write(b, 0, byteread);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(">>>>> 复制单个文件失败，文件名：" + oldName);
                }
                bytesum += byteread;
                System.out.println(">>>>> 单个字节数" + bytesum);
            }
        }
    }
}
