package src.graph.mincostconnectpoints1584;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/19 11:06:33
 * description:
 * 参考：https://leetcode-cn.com/problems/min-cost-to-connect-all-points/solution/javashuang-bai-kruskalsuan-fa-bing-cha-ji-pan-duan/
 */
public class AnotherSolution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        Solution.UnionFindSet ufs = new Solution.UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(len, i, j));
            }
        }
        Collections.sort(edges);
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

    static class Edge implements Comparable {
        public int length;
        public int x;
        public int y;

        public Edge(int length, int x, int y) {
            this.length = length;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Edge e = (Edge) o;
            return length - e.length;
        }
    }
}
