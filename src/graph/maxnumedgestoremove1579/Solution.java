package src.graph.maxnumedgestoremove1579;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/27 09:07:57
 * description:
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *
 * 类型 1：只能由 Alice 遍历。
 * 类型 2：只能由 Bob 遍历。
 * 类型 3：Alice 和 Bob 都可以遍历。
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 *
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * 输出：2
 * 解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所以可以删除的最大边数是 2 。
 * 示例 2：
 *
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
 * 输出：0
 * 解释：注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
 * 示例 3：
 *
 * 输入：n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
 * 输出：-1
 * 解释：在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * 1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2)
 * edges[i].length == 3
 * 1 <= edges[i][0] <= 3
 * 1 <= edges[i][1] < edges[i][2] <= n
 * 所有元组 (typei, ui, vi) 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
 *
 * 参考：https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/solution/bao-zheng-tu-ke-wan-quan-bian-li-by-leet-mtrw/
 * 参考：https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/solution/javacha-ji-si-lu-fen-xiang-xiang-xi-zhu-ltud6/
 */
public class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // 排序，将类型3的边排到最前面
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int ans = 0;
        UnionFindSet ufs1 = new UnionFindSet(n);
        UnionFindSet ufs2 = new UnionFindSet(n);
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufs1.find(edge[1] - 1) == ufs1.find(edge[2] - 1)) {
                    ans++;
                } else {
                    ufs1.union(edge[1] - 1, edge[2] - 1);
                    ufs2.union(edge[1] - 1, edge[2] - 1);
                }
            } else if (edge[0] == 1) {
                if (ufs1.find(edge[1] - 1) == ufs1.find(edge[2] - 1)) {
                    ans++;
                } else {
                    ufs1.union(edge[1] - 1, edge[2] - 1);
                }
            } else if (edge[0] == 2) {
                if (ufs2.find(edge[1] - 1) == ufs2.find(edge[2] - 1)) {
                    ans++;
                } else {
                    ufs2.union(edge[1] - 1, edge[2] - 1);
                }
            }
        }
        if (ufs1.count == 1 && ufs2.count == 1) {
            return ans;
        }
        return -1;
    }

    static class UnionFindSet {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFindSet(int n) {
            count = n;
            rank = new int[n];
            parent = new int[n];
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

        public boolean union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                // 两点已经连通
                return false;
            }
            if (rank[fy] < rank[fx]) {
                parent[fy] = fx;
            } else {
                parent[fx] = fy;
            }
            if (rank[fx] == rank[fy]) {
                rank[fy]++;
            }
            count--;
            return true;
        }

        public int count() {
            return count;
        }
    }
}
