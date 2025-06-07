package com.zxw.demo.algorithm.dijkstra;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: Ryan
 * @Date: 2025/5/28 15:45
 * @Version: 1.0
 * @Description: <h5>Dijkstra（）算法（最短距离类型的问题）<h5/>
 * <p>&emsp;&emsp;此算法可用于权重类/距离/以及时间等问题；</p>
 * <p>&emsp;&emsp;是从第一个1位置（a）开始找，能够到达的最近下一个位置（b），然后在 b 这个位置查找b的路线能到哪些位置（c），
 *  那到 c 位置最近的距离就是以前路线保存的或者现在这条路线；</p>
 * <p>&emsp;&emsp;由于每次往下扫描都加上了当前的距离的，所以得出来的距离是总距离；</p>
 * <p>&emsp;&emsp;可以理解为每次经过 a（外层循环的值，路线） 点，作为路线轴点，走 a 路线向下找最近的路线，
 *  相当于走 a 路线最近的路线能到达哪些位置（b）（就能找到去 b 位置的当前最近位置【原位置当前路的位置】）；</p>
 * <p>&emsp;&emsp;最重要的是每条路线找出来还要以前到达过该位置的值比较交换</p>
 *
 * <br><strong>测试数据示例（每个数字都是一次输入）：</strong>
 * <p>&emsp;&emsp;6, 8 （6个位置8组数据）
 * <p>&emsp;&emsp;{1, 2, 8}, {1, 3, 4} (从1出发的两组数据)
 * <p>&emsp;&emsp;{2, 4, 4} (从2出发的一组数据)
 * <p>&emsp;&emsp;{3, 2, 2}, {3, 4, 6}, {3, 5, 6} (从3出发的三组数据)
 * <p>&emsp;&emsp;{4, 6, 4} (从4出发的一组数据)
 * <p>&emsp;&emsp;{5, 4, 2} (从5出发的一组数据)
 *
 * <br><strong>参考：</strong>
 * <p>&emsp;&emsp;https://blog.csdn.net/ixiaotang_/article/details/146443718
 */
@Slf4j
@Data
public class Dijkstra {

    /**
     * 表示无穷大距离（没有这条路）
     * <p>
     * 这里因为需要比较大小所以选择了一个很大的数字默认
     */
    private static int INF = 0X3F3F3F3F;

    /**
     * 邻接表（当前位置到达其它位置的距离）
     * <p>
     * 比如：
     *      1. {2, 3}, {3, 5}
     *      2. {3, 8}, {5, 9}
     *      3. {5, 8}, {2, 9}
     *      .......
     * 代表了位置1到达2需要3km，位置1到达3需要5km；位置2到达3需要8km，位置2到达5需要9km；位置3到达5需要8km，位置3到达2需要9km 等等
     */
    private List<int[]>[] adjacencyList;

    /**
     * 判断是否以某个节点为中心进行扫描过(下标代表位置)
     */
    private boolean[] centerFlagArray;

    /**
     * 记录到每个位置极端值（比如最近的距离）
     */
    private int[] mostArray;

    /**
     * n 个位置
     */
    private int n;

    /**
     * 某个位置到另一个位置的距离输入数据量（数据的组数，输入多少次）
     * <p>
     * 包含三个参数：
     *      a(位置)
     *      b(位置)
     *      c(距离)
     */
    private int m;

    /**
     *
     */
    private PriorityQueue priorityQueue;

    /**
     * dijkstra
     */
    public void dijkstra() {

        Scanner in = new Scanner(System.in);

        System.out.println("请输入位置总数：");
        n = in.nextInt();
        System.out.println("请输入数据组数：");
        m = in.nextInt();

        // 初始化容器
        adjacencyList = new List[m + 1];
        centerFlagArray = new boolean[n + 1];
        mostArray = new int[n + 1];

        // 输入并初始化数据
        for (int i = 1; i <= m; i++) {
            System.out.println("请输入第" + i + "组数据出发点：");
            // 位置 a
            int a = in.nextInt();
            System.out.println("请输入第" + i + "组数据目的地：");
            // 位置 b
            int b = in.nextInt();
            System.out.println("请输入第" + i + "组数据距离：");
            // 距离 c
            int c = in.nextInt();

            // 如果位置 a 出发的数组为空（第一次输入 a 出发的数据），新建一下数组
            if (adjacencyList[a] == null) {
                adjacencyList[a] = new ArrayList<>();
            }

            // 保存当前组数据 b 到达地点，c 为距离
            adjacencyList[a].add(new int[]{b, c});
        }

        // 执行 dijkstra 算法
        doDijkstra();

        // 如果是初始值则返回-1，代表没有1到该地路线
        System.out.println("1->" + n + "最短路程为：" + (mostArray[n] == INF ? -1 : mostArray[n]));

    }

    public void dijkstraOptimized() {

        Scanner in = new Scanner(System.in);

        System.out.println("请输入位置总数：");
        n = in.nextInt();
        System.out.println("请输入数据组数：");
        m = in.nextInt();

        // 初始化容器
        adjacencyList = new List[m + 1];
        centerFlagArray = new boolean[n + 1];
        mostArray = new int[n + 1];

        // 输入并初始化数据
        for (int i = 1; i <= m; i++) {
            System.out.println("请输入第" + i + "组数据出发点：");
            // 位置 a
            int a = in.nextInt();
            System.out.println("请输入第" + i + "组数据目的地：");
            // 位置 b
            int b = in.nextInt();
            System.out.println("请输入第" + i + "组数据距离：");
            // 距离 c
            int c = in.nextInt();

            // 如果位置 a 出发的数组为空（第一次输入 a 出发的数据），新建一下数组
            if (adjacencyList[a] == null) {
                adjacencyList[a] = new ArrayList<>();
            }

            // 保存当前组数据 b 到达地点，c 为距离
            adjacencyList[a].add(new int[]{b, c});
        }

        // 执行 dijkstra 算法
        doDijkstraOptimized();

        // 如果是初始值则返回-1，代表没有1到该地路线
        System.out.println("1->" + n + "最短路程为：" + (mostArray[n] == INF ? -1 : mostArray[n]));

    }

    /**
     * 执行 dijkstra 算法
     *
     * <p>
     *     这里有不完善的地方，内层 for 循环也是从1~6所以不管能不能到达都会去处理一遍，尽管
     * </p>
     */
    private void doDijkstra() {
        // 初始化最近距离为无穷大（0X3F3F3F3F），代表没有到达某个地方
        Arrays.fill(mostArray, INF);

        // 1 -> 1 距离为0
        mostArray[1] = 0;

        // 出发点是从1开始（说白了这个外层循环是从出发点的下一步开始的，下一步可能是1/2/3/4/5/6这样一步步排查）
        // 从1开始进行扫描(走1这条路线开始，然后2/3/4/5/6路线，1->1, 1->2, 1->3, 1->4, 1->5, 1->6 的路线循环排查)
        for (int i = 1; i <= n; i++) {
            // 用 u 来表示目前能探索的路径最短节点
            int u = -1;

            for (int j = 1; j <= n; j++) {
                // 如果 j 位置已经扫描过，则不需要考虑了
                if (centerFlagArray[j]) {
                    continue;
                }

                // -1 代表没有探索过，如果到 j 路线的距离更小则标记 j 位置（以为你走 i 这条路的话，到下一个点最近路线）
                // 相当于每一步都找最近的下一个点
                if (u == -1 || mostArray[j] < mostArray[u]) {
                    u = j;
                }
            }

            centerFlagArray[u] = true;

            // 此时已经找到可探寻路径中最短的
            // 1->1 就是最短的，找到了1这个路线，这个路线的如果有到其它位置的就继续没有的就直接下一次循环
            if (adjacencyList[u] == null) {
                continue;
            }

            // 路径（链路）, 从当前路线中选取下一步的最短地点的路线列表
            List<int[]> link = adjacencyList[u];

            // 循环比较经过当前节点 j 通向其它位置的路线的总距离，加上原本距离 u 到目的地 v 的距离 w，和一起记录的 v 的距离比较
            // 每一步都往前加起走了的，所以是总距离
            for (int k = 0; k < link.size(); k++) {
                // 目的地的节点
                int v = link.get(k)[0];
                // 目的地的距离（权重）
                int w = link.get(k)[1];
                // 小于则替换，大于等于则不管（取原值）
                mostArray[v] = Math.min(mostArray[v], mostArray[u] + w);
            }
        }
    }

    /**
     * 优化后的 dijkstra 算法（堆优化）todo 这个有问题
     */
    private void doDijkstraOptimized() {
        // 初始化最近距离为无穷大（0X3F3F3F3F），代表没有到达某个地方
        Arrays.fill(mostArray, INF);

        // 1 -> 1 距离为0
        mostArray[1] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(k -> k[1]));

        priorityQueue.add(new int[]{1, 0});
        priorityQueue.add(new int[]{2, INF});
        priorityQueue.add(new int[]{3, INF});
        priorityQueue.add(new int[]{4, INF});
        priorityQueue.add(new int[]{5, INF});
        priorityQueue.add(new int[]{6, INF});

        while (!priorityQueue.isEmpty()) {
            int[] t = priorityQueue.poll();
            if (centerFlagArray[t[0]]) {
                continue;
            }

            centerFlagArray[t[0]] = true;

            for (int[] arr : adjacencyList[t[0]]) {
                int v = arr[0];
                int w = arr[1];
                mostArray[v] = Math.min(mostArray[v], mostArray[t[0]] + w);
            }
        }

        System.out.println("priorityQueue:" + JSON.toJSONString(priorityQueue));
    }

}
