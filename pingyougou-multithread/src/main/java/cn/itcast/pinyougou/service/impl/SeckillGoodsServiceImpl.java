package cn.itcast.pinyougou.service.impl;

import cn.itcast.pinyougou.mapper.TbSeckillGoodsMapper;
import cn.itcast.pinyougou.pojo.TbSeckillGoods;
import cn.itcast.pinyougou.pojo.TbSeckillOrder;
import cn.itcast.pinyougou.service.SeckillGoodsService;
import cn.itcast.pinyougou.thread.OrderCreateThread;
import cn.itcast.pinyougou.utils.IdWorker;
import cn.itcast.pinyougou.utils.OrderRecord;
import cn.itcast.pinyougou.utils.Result;
import cn.itcast.pinyougou.utils.SystemConst;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicBorders;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Ryan
 * @Date: 2020/7/17 16:17
 * @Version: 1.0
 * @Description:
 */
@Service
@Transactional
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    private IdWorker idWorker;

    @Resource
    private TbSeckillGoodsMapper seckillGoodsMapper;

    @Resource
    private ThreadPoolTaskExecutor executor;

    @Resource
    private OrderCreateThread orderCreateThread;


    @Override
    public List<TbSeckillGoods> findAll() {
        return redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).values();
    }

    @Override
    public TbSeckillGoods findOne(Long id) {
        return (TbSeckillGoods) redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).get(id);
    }

    @Override
    public Result saveOrder(Long id, String userId) {
        // 从 redis 用户集合中判断用户是否已下单
        Boolean boo = redisTemplate.boundSetOps(SystemConst.CONST_USER_ID_PREFIX + id).isMember(userId);
        if (boo) {
            // 如果有下单则提示已下单或者订单未支付
            return new Result(false, "Sorry...你已经秒杀了该商品，请尽快支付!!!");
        }

        // 从 list 中拿商品的 id
        id = (Long) redisTemplate.boundListOps(SystemConst.CONST_SECKILLGOODS_ID_PREFIX + id).rightPop();
        if (id == null) {
            return new Result(false, "Sorry...商品已售罄！！！");
        }

        // 将用户放入集合表示已经秒杀到商品
        redisTemplate.boundSetOps(SystemConst.CONST_USER_ID_PREFIX + id).add(userId);
        // orderRecord 记录秒杀成功的用户和商品id，创建订单用
        OrderRecord orderRecord = new OrderRecord(id, userId);
        redisTemplate.boundListOps(OrderRecord.class.getSimpleName()).leftPush(orderRecord);
        // 通过线程池处理秒杀成功 集合信息 orderRecord
        executor.execute(orderCreateThread);
        return new Result(true, "秒杀成功，请尽快支付");
    }
}