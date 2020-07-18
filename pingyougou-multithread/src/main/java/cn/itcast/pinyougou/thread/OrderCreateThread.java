package cn.itcast.pinyougou.thread;

import cn.itcast.pinyougou.mapper.TbSeckillGoodsMapper;
import cn.itcast.pinyougou.pojo.TbSeckillGoods;
import cn.itcast.pinyougou.pojo.TbSeckillOrder;
import cn.itcast.pinyougou.utils.IdWorker;
import cn.itcast.pinyougou.utils.OrderRecord;
import cn.itcast.pinyougou.utils.SystemConst;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2020/7/18 15:12
 * @Version: 1.0
 * @Description:
 */
@Component // 交给 spring 管理
public class OrderCreateThread implements Runnable {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private IdWorker idWorker;

    @Resource
    private TbSeckillGoodsMapper seckillGoodsMapper;

    @Override
    public void run() {
        // 从 redis 获取秒杀成功信息生成订单
        OrderRecord orderRecord = (OrderRecord) redisTemplate.boundListOps(OrderRecord.class.getSimpleName()).rightPop();
        Long id = orderRecord.getId();
        String userId = orderRecord.getUserId();
        // 从 redis 获取秒杀商品
        TbSeckillGoods tbSeckillGoods = (TbSeckillGoods) redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).get(id);
        // 生成秒杀订单，并且保存到 redis
        TbSeckillOrder tbSeckillOrder = new TbSeckillOrder();
        tbSeckillOrder.setUserId(userId);
        tbSeckillOrder.setSellerId(tbSeckillGoods.getSellerId());
        tbSeckillOrder.setSeckillId(idWorker.nextId());
        tbSeckillOrder.setMoney(tbSeckillGoods.getCostPrice());
        tbSeckillOrder.setCreateTime(new Date());
        tbSeckillOrder.setStatus("0"); // 未支付
        redisTemplate.boundHashOps(TbSeckillOrder.class.getSimpleName()).put(userId, tbSeckillOrder);
        synchronized (OrderCreateThread.class) {
            tbSeckillGoods = (TbSeckillGoods) redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).get(id); // 重新拿一遍，防止并发数据出错
            // 库存减1
            tbSeckillGoods.setStockCount(tbSeckillGoods.getStockCount() - 1);
            if (tbSeckillGoods.getStockCount() <= 0) {
                // 更新到数据库，并且删除秒杀商品
                seckillGoodsMapper.updateByPrimaryKey(tbSeckillGoods);
                redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).delete(id);
            } else {
                // 没有卖完存入 redis
                redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).put(id, tbSeckillGoods);
            }
        }

    }
}
