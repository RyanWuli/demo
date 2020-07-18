package cn.itcast.pingyougou.task;

import cn.itcast.pinyougou.mapper.TbSeckillGoodsMapper;
import cn.itcast.pinyougou.pojo.TbSeckillGoods;
import cn.itcast.pinyougou.pojo.TbSeckillGoodsExample;
import cn.itcast.pinyougou.utils.SystemConst;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2020/7/17 14:42
 * @Version: 1.0
 * @Description:
 */
@Component
public class SeckillGoodsToRedisTask {

    @Resource
    private TbSeckillGoodsMapper tbSeckillGoodsMapper;

    @Resource
    private RedisTemplate redisTemplate;


//    @Scheduled(cron = "0/30 * * * * ?")
//    public void importToRedis() {
//        System.out.println("执行定时任务：" + new Date());
//    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void goodsToRedis() {
        // 查询秒杀的商品（状态为有效|status=1，库存>0|stockCount>0，秒杀开始时间<=当前时间<秒杀结束时间）
        TbSeckillGoodsExample example = new TbSeckillGoodsExample();
        TbSeckillGoodsExample.Criteria criteria = example.createCriteria();
        Date date = new Date();
        criteria.andStatusEqualTo("1")
                .andStockCountGreaterThan(0)
                .andStartTimeLessThan(date)
                .andEndTimeGreaterThan(date);
        List<TbSeckillGoods> tbSeckillGoods = tbSeckillGoodsMapper.selectByExample(example);
        // 存入 redis
        for (TbSeckillGoods goods : tbSeckillGoods) {
            redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).put(goods.getId(), goods);
            // 为每个商品创建一个队列，每个队列里面放入对应库存量个数的当前商品 id
            createQueue(goods.getId(), goods.getStockCount());
        }
    }

    public void createQueue(Long id, Integer stockCount) {
        if (stockCount > 0) {
            for (int i = 0; i < stockCount; i++) {
                redisTemplate.boundListOps(SystemConst.CONST_SECKILLGOODS_ID_PREFIX + id).leftPush(id);
            }
        }
    }

}
