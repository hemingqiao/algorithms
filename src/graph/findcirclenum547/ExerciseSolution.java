package src.graph.findcirclenum547;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/28 11:13:21
 * description:
 */
public class ExerciseSolution {
    // 使用并查集
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFindSet ufs = new UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    ufs.union(i, j);
                }
            }
        }
        return ufs.count;
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

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) {
                // 如果px == py，表明已经连通
                return;
            }
            // 否则，将秩较小的结点合并到秩较大的结点上
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
            }
            if (rank[px] == rank[py]) {
                rank[py]++;
            }
            count--;
        }

        public int count() {
            return this.count;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
