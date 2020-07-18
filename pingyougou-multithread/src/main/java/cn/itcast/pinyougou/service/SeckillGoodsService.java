package cn.itcast.pinyougou.service;

import cn.itcast.pinyougou.pojo.TbSeckillGoods;
import cn.itcast.pinyougou.utils.Result;

import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2020/7/17 16:16
 * @Version: 1.0
 * @Description:
 */
public interface SeckillGoodsService {

    List<TbSeckillGoods> findAll();

    TbSeckillGoods findOne(Long id);

    Result saveOrder(Long id, String userId);
}
