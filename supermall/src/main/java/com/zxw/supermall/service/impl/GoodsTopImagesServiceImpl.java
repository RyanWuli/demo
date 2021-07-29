package com.zxw.supermall.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxw.supermall.entity.GoodsTopImages;
import com.zxw.supermall.mapper.GoodsTopImagesMapper;
import com.zxw.supermall.service.IGoodsTopImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Ryan
 * @since 2020-08-20
 */
@Service
public class GoodsTopImagesServiceImpl extends ServiceImpl<GoodsTopImagesMapper, GoodsTopImages> implements IGoodsTopImagesService {

//    public List<Object> getTopImages(String iid) {
//        QueryWrapper<GoodsTopImages> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("iid", iid);
//        return listObjs(queryWrapper);
//    }
}
