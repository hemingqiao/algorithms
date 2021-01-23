package blogandquestion.algorithms.graph.makeconnected1319;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/23 10:13:08
 * description:
 * 参考：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/solution/lian-tong-wang-luo-de-cao-zuo-ci-shu-by-leetcode-s/
 * 参考：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/solution/javabing-cha-ji-hao-li-jie-by-bb3akxpsac-ahed/
 */
public class Solution {
    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        if (size < n - 1) return -1;
        UnionFindSet ufs = new UnionFindSet(n);
        for (int[] conn : connections) {
            ufs.union(conn[0], conn[1]);
        }
        return ufs.count() - 1;
    }

    static class UnionFindSet {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFindSet(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return; // 如果fx == fy，表明x和y已经联通
            }
            // 否则，将秩较小的节点合并到秩较大的节点上
            if (rank[fx] < rank[fy]) {
                parent[fx] = fy;
            } else {
                parent[fy] = fx;
            }
            if (rank[fx] == rank[fy]) {
                rank[fy]++;
            }
            count--;
        }

        public int count() {
            return count;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
