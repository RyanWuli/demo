package com.fastdfs.client;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @Author: Ryan
 * @Date: 2021/3/27 18:56
 * @Version: 1.0
 * @Description:
 */
@Slf4j
@Component
public class FastFDSClient {

    private final String PRE_URL = "http://47.107.139.152:8888/";

    public String uploadFile(MultipartFile file) throws IOException, MyException {

        String filename = file.getOriginalFilename();
        String fileType = filename.substring(filename.lastIndexOf(".") + 1);
        System.out.println("---------------> 类型：" + fileType);

        // 初始化全局配置，加载一个配置文件
        String p = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        ClientGlobal.init(p);

        // 创建一个 trackerClient 对象
        TrackerClient trackerClient = new TrackerClient();
        // 常见一个 trackerServer 对象
        TrackerServer trackerServer = trackerClient.getConnection();
        // 声明一个 storageServer
        StorageServer server = null;
        // 获得 storageClient 对象
        StorageClient client = new StorageClient(trackerServer, server);
        byte[] bytes = file.getBytes(); // 获取文件的二进制对象
        String[] strings = client.upload_file(bytes, fileType, null);
        Stream.of(strings).forEach(System.out::println);
        String url = PRE_URL + strings[0] + "/" + strings[1];
        return url;
    }
}
