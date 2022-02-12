package src.graph.swiminwater778;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 09:46:04
 * description:
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 *
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 *
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 *
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 * 示例2:
 *
 * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * 输出: 16
 * 解释:
 *  0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 *
 * 最终的路线用加粗进行了标记。
 * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
 *  
 *
 * 提示:
 *
 * 2 <= N <= 50.
 * grid[i][j] 是 [0, ..., N*N - 1] 的排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
 *
 * 除了并查集之外还有深搜和广搜的做法（参考1），以后补上
 * 参考：https://leetcode-cn.com/problems/swim-in-rising-water/solution/shui-wei-shang-sheng-de-yong-chi-zhong-y-862o/
 * 参考：https://leetcode-cn.com/problems/swim-in-rising-water/solution/java-duo-chong-si-lu-zong-you-yi-ge-gua-dnxkf/
 */
public class Solution {
    public int swimInWater(int[][] grid) {
        List<int[]> list = new ArrayList<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = i * n + j;
                if (i > 0) {
                    list.add(new int[]{pos - n, pos, Math.max(grid[i - 1][j], grid[i][j])});
                }
                if (j > 0) {
                    list.add(new int[]{pos - 1, pos, Math.max(grid[i][j - 1], grid[i][j])});
                }
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int res = 0;
        UnionFindSet ufs = new UnionFindSet(n * n);
        for (int[] edge : list) {
            int x = edge[0], y = edge[1], v = edge[2];
            ufs.union(x, y);
            if (ufs.isConnected(0, n * n - 1)) {
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
            if (parent[fx] < parent[fy]) {
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
