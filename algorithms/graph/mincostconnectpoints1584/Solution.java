package blogandquestion.algorithms.graph.mincostconnectpoints1584;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/19 09:51:54
 * description:
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= points.length <= 1000
 * -10^6 <= xi, yi <= 10^6
 * 所有点 (xi, yi) 两两不同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 *
 * 最小生成树？
 * 参考：https://leetcode-cn.com/problems/min-cost-to-connect-all-points/solution/lian-jie-suo-you-dian-de-zui-xiao-fei-yo-kcx7/
 * 参考：https://leetcode-cn.com/problems/min-cost-to-connect-all-points/solution/c-kruskalprimsuan-fa-jie-da-by-yizhe-shi/
 */
public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        UnionFindSet ufs = new UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(len, i, j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.length - o2.length;
            }
        });
        int ret = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.length, x = edge.x, y = edge.y;
            if (!ufs.connected(x, y)) {
                ufs.union(x, y);
                ret += len;
                num++;
                if (num == n) break;
            }
        }
        return ret;
    }

    static class UnionFindSet {
        private int[] parent; // 记录父节点
        private int[] rank; // 记录每个节点对应的树的深度
        private int count;

        public UnionFindSet(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        // 查找，并执行路径压缩
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
//            return parent[x] = find(x) == x ? x : find(parent[x]);
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            // 两个节点已经联通
            if (fx == fy) {
                return;
            }
            // 否则，按秩进行合并
            // 将秩小的树合并到秩大的树上
            if (rank[fx] > rank[fy]) {
                parent[fy] = fx;
            } else {
                parent[fx] = fy;
            }
            if (rank[fx] == rank[fy]) {
                rank[fy]++;
            }
            count--; // 每union一次，子树数目减1
        }

        public int count() {
            return count;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    static class Edge {
        public int length;
        public int x;
        public int y;

        public Edge(int length, int x, int y) {
            this.length = length;
            this.x = x;
            this.y = y;
        }
    }

    // for test
    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        Solution s = new Solution();
        int res = s.minCostConnectPoints(points);
        System.out.println(res);
    }
}
