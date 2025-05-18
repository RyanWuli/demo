package work.juc;

import com.zxw_work.juc.executor.MyThreadPoolExecutorFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Ryan
 * @Date: 2024/10/31 16:43
 * @Version: 1.0
 * @Description: 自定义线程池测试
 */
@Slf4j
public class ThreadPoolTest {

    /**
     * 测试自定义线程池和线程
     * <p>
     * threadNum 更改线程数可以测试出 核心线程数、最大线程数和队列的关系为：
     *      当任务 <= 核心线程数的时候（核心线程数够用），只有核心线程，没有最大线程，队列也为空
     *      当核心线程数 <= 任务 <= 队列数+核心线程数的时候（队列没满），只有核心线程，没有最大线程，超过核心线程的任务放队列
     *      当核心队列数+核心线程数的时候 < 任务 < 队列数+最大线程数（核心线程池用完了，队列没有满）既有核心线程，又有最大线程，队列也有数据
     *      当任务 > 最大线程数+队列数（所有线程池中线程都使用了，队列也没地方放了，走拒绝策略了）核心线程，最大线程，队列都是满载
     *
     * @throws InterruptedException 线程中断异常
     */
    @Test
    public void testMyThreadPool() throws InterruptedException {
        ThreadPoolExecutor executor =
                MyThreadPoolExecutorFactory.getPoolExecutor(MyThreadPoolExecutorFactory.MY_POOL_NAME);

        /*
        * 5     5s      5个核心线程同时执行1次    5x1     s
        * 55    55s     5个核心线程同时执行11次   5x11    s
        * 65    25s     15个线程全部开启执行5次   5x5     s
        *
        * 95 个任务分析
        * 时间点（表示开始开始执行时间） 线程池任务情况							    main（主线程阻塞执行）	    total任务
        * 0								15（线程）+ 50（队列）					1						66
        * 5								15（队列拿出到线程）+ 35 + 15（补满）	1						82
        * 10							15（队列拿出到线程）+ 35 + 13（补满）	0（全部分配给线程池）	    95
        * 15							15（队列拿出到线程）+ 33（队列）		    0						95
        * 20							15（队列拿出到线程）+ 18（队列）		    0						95
        * 25							15（队列拿出到线程）+ 3（队列）			0						95
        * 30							 3（队列拿出到线程）+ 0（队列）			0						95
        * 35	30秒开始执行的数据还需要5秒执行完毕，所以最终执行时间是35s
        *
        * */
        int threadNum = 95;

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            int finalI = i;
            executor.execute(() -> {
                log.info("this is {} start...", (finalI + 1));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("this is {} end...", (finalI + 1));
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

    }

}
