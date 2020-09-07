package com.zxw.supermall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxw.supermall.entity.GoodsTopImages;
import com.zxw.supermall.service.IGoodsTopImagesService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ryan
 * @since 2020-08-20
 */
@Slf4j
@RestController
@RequestMapping("/supermall/goods-top-images")
public class GoodsTopImagesController  {

    @Autowired
    IGoodsTopImagesService iGoodsTopImagesService;

    @GetMapping("/{iid}")
    public List<GoodsTopImages> getImagesByIid(@PathVariable("iid") String iid) {
        log.info(iid);
        QueryWrapper<GoodsTopImages> queryWrapper = new QueryWrapper<GoodsTopImages>();
        queryWrapper.eq("iid", iid);
        // 条件查询
        return iGoodsTopImagesService.list(queryWrapper);
    }
}
