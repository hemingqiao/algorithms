package blogandquestion.algorithms.graph.numbusestodestination815;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/26 15:14:43
 * description:
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 *
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 *
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *
 *
 *
 * 提示：
 *
 *     1 <= routes.length <= 500
 *     1 <= routes[i].length <= 10^5
 *     routes[i] 中的所有值 互不相同
 *     sum(routes[i].length) <= 10^5
 *     0 <= routes[i][j] < 10^6
 *     0 <= source, target < 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 *
 */
public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>(); // map用来记录每个公交站点上都挂在了哪些公交线路
        Deque<Integer> q = new ArrayDeque<>();
        int n = routes.length;
        int[] dist = new int[n];
        Arrays.fill(dist, 1000000);
        for (int i = 0; i < n; i++) {
            for (int x : routes[i]) {
                if (x == source) {
                    dist[i] = 1; // 起始公交路线
                    q.offer(i);
                }
                if (!map.containsKey(x)) map.put(x, new ArrayList<>());
                map.get(x).add(i); // 将公交路线挂载到公交站点
            }
        }
        while (!q.isEmpty()) {
            int r = q.poll(); // 公交线路
            for (int x : routes[r]) {
                if (x == target) return dist[r];
                if (map.containsKey(x)) {
                    for (int y : map.get(x)) {
                        if (dist[y] > dist[r] + 1) {
                            dist[y] = dist[r] + 1;
                            q.offer(y);
                        }
                    }
                }
                map.remove(x);
            }
        }
        return -1;
    }
}
