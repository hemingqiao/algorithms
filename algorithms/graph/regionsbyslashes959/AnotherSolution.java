package blogandquestion.algorithms.graph.regionsbyslashes959;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/25 13:28:54
 * description:
 * 参考：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/xian-yong-tu-xiang-chu-li-de-sao-cao-zuo-miao-liao/
 * 参考：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/bing-cha-ji-java-by-yan-yuan-oh-l3jk/
 */
public class AnotherSolution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFindSet ufs = new UnionFindSet((n + 1) * (n + 1));
        for (int i = 0; i < n; i++) {
            ufs.union(i, i + 1);// 连接最上面中的两个点
            ufs.union(n * (n + 1) + i, n * (n + 1) + i + 1);// 连接最下面中的两个点
            ufs.union(i * (n + 1), (i + 1) * (n + 1));// 连接最左面中的两个点
            ufs.union(i * (n + 1) + n, (i + 1) * (n + 1) + n);// 连接最右面中的两个点
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '\\') {
                    int x = i * (n + 1) + j;
                    int y = (i + 1) * (n + 1) + j + 1;
                    if (!ufs.union(x, y)) {
                        res++;
                    }
                } else if (grid[i].charAt(j) == '/') {
                    int x = i * (n + 1) + j + 1;
                    int y = (i + 1) * (n + 1) + j;
                    if (!ufs.union(x, y)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    static class UnionFindSet {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFindSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
            rank = new int[n];
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx == fy) {
                return false; // 两个点已经联通
            }

            if (rank[fx] < rank[fy]) {
                parent[fx] = fy;
            } else {
                parent[fy] = fx;
            }

            if (rank[fx] == rank[fy]) {
                rank[fy]++;
            }
            count--;
            return true;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int count() {
            return count;
        }
    }
}
