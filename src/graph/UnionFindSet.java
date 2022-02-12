package src.graph;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/13 10:26:31
 * description:
 * 并查集的Java实现
 * 参考：https://leetcode-cn.com/problems/minimize-hamming-distance-after-swap-operations/solution/5650-zhi-xing-jiao-huan-cao-zuo-hou-de-z-rk3i/
 * 参考：https://oi-wiki.org/ds/dsu/
 */
public class UnionFindSet {
    private int[] parent;
    // 用一个数组rank[]记录每个根节点对应的树的深度（如果不是根节点，其rank相当于以它作为根节点的子树的深度）。一开始，把所有元素的
    // rank（秩）设为1。合并时比较两个根节点，把rank较小者往较大者上合并
    private int[] rank;
    private int count;

    public UnionFindSet(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    // 路径压缩
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // 按秩合并
    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        // 如果fx == fy，表示这两个子树已经联通，
        if (fx == fy) {
            return;
        }

        // 应该把简单的树往复杂的树上合并（将秩小的树合并到秩大的树上）
        if (rank[fx] > rank[fy]) {
            parent[fy] = fx;
        } else {
            parent[fx] = fy;
        }

        if (rank[fx] == rank[fy]) {
            // 如果深度相同，则新的根节点的深度加1
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
