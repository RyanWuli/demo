package com.zxw.demo.algorithm.dijkstra;

import java.util.*;

/**
 * @Author: Ryan
 * @Date: 2025/5/29 18:14
 * @Version: 1.0
 * @Description: add the description
 */
public class DijkstraAlgorithm {

    // 定义图的邻接表表示：Map<起点, List<边>>
    private Map<Integer, List<Edge>> graph = new HashMap<>();

    // 添加边到图中
    public void addEdge(int from, int to, int weight) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Edge(to, weight));
    }

    // 计算从起点 start 到所有节点的最短距离
    public int[] dijkstra(int start, int numNodes) {
        // 初始化距离数组：distances[i] 表示 start 到 i 的最短距离
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // 优先队列：按当前最短距离排序（格式：[节点, 距离]）
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        // 已确定最短路径的节点集合
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            // 如果当前节点已处理过，跳过
            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            // 遍历当前节点的所有邻居
            if (graph.containsKey(currentNode)) {
                for (Edge edge : graph.get(currentNode)) {
                    int neighbor = edge.to;
                    int newDist = currentDist + edge.weight;

                    // 松弛操作：更新最短距离
                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        pq.offer(new int[]{neighbor, newDist});
                    }
                }
            }
        }

        return distances;
    }

    // 边类（表示一条有向边）
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        // 构建示例图
        dijkstra.addEdge(0, 1, 4);
        dijkstra.addEdge(0, 2, 1);
        dijkstra.addEdge(1, 3, 1);
        dijkstra.addEdge(2, 1, 2);
        dijkstra.addEdge(2, 3, 5);
        dijkstra.addEdge(3, 4, 3);

        int startNode = 0;
        int[] distances = dijkstra.dijkstra(startNode, 5);

        // 输出结果
        System.out.println("从节点 " + startNode + " 出发的最短路径：");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("到节点 " + i + " 的最短距离: " +
                    (distances[i] == Integer.MAX_VALUE ? "不可达" : distances[i]));
        }
    }
}
