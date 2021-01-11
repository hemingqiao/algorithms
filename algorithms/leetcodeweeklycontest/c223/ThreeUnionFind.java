package blogandquestion.algorithms.leetcodeweeklycontest.c223;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/10 10:53:53
 * description:
 * 给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换
 * 数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 *
 * 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）
 * 的下标 i（0 <= i <= n-1）的数量。
 *
 * 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 *
 * 示例 1：
 *
 * 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * 输出：1
 * 解释：source 可以按下述方式转换：
 * - 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
 * - 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
 * source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 * 示例 2：
 *
 * 输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
 * 输出：2
 * 解释：不能对 source 执行交换操作。
 * source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。
 * 示例 3：
 *
 * 输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
 * 输出：0
 *
 * 提示：
 *
 * n == source.length == target.length
 * 1 <= n <= 10^5
 * 1 <= source[i], target[i] <= 10^5
 * 0 <= allowedSwaps.length <= 10^5
 * allowedSwaps[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 链接：https://leetcode-cn.com/problems/minimize-hamming-distance-after-swap-operations/
 *
 * 参考：https://leetcode-cn.com/problems/minimize-hamming-distance-after-swap-operations/solution/5650-zhi-xing-jiao-huan-cao-zuo-hou-de-z-rk3i/
 */
public class ThreeUnionFind {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int ans = 0, n = source.length;
        UnionFind unionFind = new UnionFind(n);
        for (int[] swap : allowedSwaps) {
            unionFind.union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(target[i], new LinkedList<>());
            map.get(target[i]).add(i);
        }

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(source[i])) {
                ans++;
                continue;
            }

            List<Integer> list = map.get(source[i]);
            Iterator<Integer> iterator = list.iterator();
            boolean flag = false;
            while (iterator.hasNext()) {
                Integer index = iterator.next();
                if (unionFind.connected(i, index)) {
                    iterator.remove();
                    flag = true;
                    break;
                }
            }
            if (!flag) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeUnionFind tuf = new ThreeUnionFind();
        int[] source = new int[]{1, 2, 3, 4};
        int[] target = new int[]{2, 1, 4, 5};
        int[][] allowedSwaps = new int[][]{{0, 1}, {2, 3}};
    }

    private static class UnionFind {
        private int[] parent;
        // 用一个数组rank[]记录每个根节点对应的树的深度（如果不是根节点，其rank相当于以它作为根节点的子树的深度）。一开始，把所有元素的
        // rank（秩）设为1。合并时比较两个根节点，把rank较小者往较大者上合并
        private int[] rank;
        private int count;

        public UnionFind(int n) {
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
}

/*
思路：
题目中给出条件“你可以按 任意 顺序 多次 交换一对特定下标指向的元素”，所以只要两个位置元素能通过其他中间位置间接交换，这个两位置的元素就可以交换。

根据上面的条件，我们可以把 source 数组中的每一个位置想象成图中的一个节点，数组 allowedSwaps 给出的就是节点之间的边，两个节点只要在同一个连通
分量中，那么它们就是可以进行交换的。我们对比两个数组 source 和 target，看 source 数组 i 位置的元素能否交换到 i 位置元素在 target 数组中的
位置，如果不能则该位置对 source 和 target 间的最小汉明距离有贡献。

对于计算图中两个节点是否在同一个连通分量，我们可以使用并查集。

首先根据数组 allowedSwaps 初始化并查集；
然后使用哈希表映射数组 target 中的每个元素和其位置，以便后续查找数组 source 中的元素在数组 target 中的位置
遍历source 数组中的每个元素，对于 i 位置元素：
如果该元素不在 target 数组中，则对汉明距离有贡献
如果该元素在 target 数组中，通过哈希表找到其在 target 数组中的位置 j，通过并查集查看 i 和 j 是否在同一一个连通分量，如果
在本题中还要注意两个数组 source 和 target 可能存在相同的元素，所以哈希表映射数组 target时，要保存每个元素对应的位置列表。在用并查集查看是否
连通时，要将连通的位置在列表中移除。
 */
