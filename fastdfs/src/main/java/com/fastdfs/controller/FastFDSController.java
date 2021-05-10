package com.fastdfs.controller;

import com.fastdfs.client.FastFDSClient;
import org.csource.common.MyException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: Ryan
 * @Date: 2021/3/29 11:07
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FastFDSController {

    @Resource
    FastFDSClient fastFDSClient;

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException, MyException {
        System.out.println(file);
        String s = fastFDSClient.uploadFile(file);
        return s;
    }
}
