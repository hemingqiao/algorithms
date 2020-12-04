package blogandquestion.algorithms.dfs.updatematrix542;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 10:55:27
 * description:
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * 输出：
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * 示例 2：
 *
 * 输入：
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * 输出：
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *  
 *
 * 提示：
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 *
 * 参考：https://leetcode-cn.com/problems/01-matrix/solution/javacong-yan-sou-dao-dpxiang-xi-zhu-jie-by-jerrymo/
 */
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n]; // 结果集
        boolean[][] visited = new boolean[m][n]; // 用来标记是否访问过某个位置
        Queue<int[]> queue = new ArrayDeque<>();
        // 遍历矩阵，将所有值等于0的位置加入结果集并入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        // 向上右下左四个方向进行搜索
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            // 以当前坐标为原点，向四个方向进行搜索1的位置
            for (int k = 0; k < 4; k++) {
                int X = x + direction[k][0], Y = y + direction[k][1];
                // 没有访问过的地方的值一定是1，同时确保不能越界
                if (X >= 0 && X < m && Y >= 0 && Y < n && !visited[X][Y]) {
                    res[X][Y] = res[x][y] + 1;
                    visited[X][Y] = true;
                    queue.add(new int[]{X, Y}); // 将新的访问过的位置入队
                }
            }
        }
        return res;
    }
}

/**
 * 动态规划的解法
 * 参考：https://leetcode-cn.com/problems/01-matrix/solution/01ju-zhen-by-leetcode-solution/
 * 参考：https://leetcode-cn.com/problems/01-matrix/solution/javacong-yan-sou-dao-dpxiang-xi-zhu-jie-by-jerrymo/
 */
class AnotherSolution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 10001);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
            }
        }
        //状态转移
        //第一次填表从左上到右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        //第二次填表从右下到左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
