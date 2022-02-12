package src.graph.minimumeffortpath1631;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/29 10:06:17
 * description:
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights，其中heights[row][col]表示格子(row, col)的高度。一开始你在
 * 最左上角的格子 (0, 0) ，且你希望去最右下角的格子(rows-1, columns-1)（注意下标从 0 开始编号）。你每次可以往 上，下，左，右四个
 * 方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 * 示例 1：
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 *
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 *
 *
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 *
 * 提示：
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
 *
 * 参考：https://leetcode-cn.com/problems/path-with-minimum-effort/solution/zui-xiao-ti-li-xiao-hao-lu-jing-by-leetc-3q2j/
 */
public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pos = i * n + j;
                if (i > 0) {
                    list.add(new int[]{pos - n, pos, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    list.add(new int[]{pos - 1, pos, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        UnionFindSet ufs = new UnionFindSet(m * n);
        int res = 0;
        for (int[] edge : list) {
            int x = edge[0], y = edge[1], v = edge[2];
            ufs.union(x, y);
            if (ufs.isConnected(0, m * n - 1)) {
                res = v;
                break;
            }
        }
        return res;
    }

    static class UnionFindSet {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFindSet(int n) {
            rank = new int[n];
            count = n;
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

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return;
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
        }

        public int count() {
            return count;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
