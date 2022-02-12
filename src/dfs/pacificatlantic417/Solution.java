package src.dfs.pacificatlantic417;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/16 23:29:31
 * description:
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 * 提示：
 *
 *     输出坐标的顺序不重要
 *     m 和 n 都小于150
 *
 *
 *
 * 示例：
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 *
 * @see https://www.acwing.com/video/1813/
 */
public class Solution {
    int n, m;
    int[][] g; // 高度数组
    int[][] st; // 用来统计是否遍历过某个点，如果能够来到太平洋，则把最后一位置为1，如果能够到达大西洋，将倒数第二位置为1
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        g = heights;
        if (g.length == 0 || g[0].length == 0) return res;
        n = g.length;
        m = g[0].length;
        st = new int[n][m];
        for (int i = 0; i < n; i++) dfs(i, 0, 0b01);
        for (int i = 0; i < m; i++) dfs(0, i, 0b01);
        for (int i = 0; i < n; i++) dfs(i, m - 1, 0b10);
        for (int i = 0; i < m; i++) dfs(n - 1, i, 0b10);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (st[i][j] == 0b11) {
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public void dfs(int sx, int sy, int t) {
        if ((st[sx][sy] & t) != 0) return; // 与0b01或者0b10做与运算，返回非0，表示已经遍历过
        st[sx][sy] |= t; // 标记遍历过这个点
        for (int i = 0; i < 4; i++) {
            int a = sx + dx[i], b = sy + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && g[a][b] >= g[sx][sy]) {
                dfs(a, b, t);
            }
        }
    }
}
