package src.dfs.longestincreasingpath329;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/18 19:27:05
 * description:
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 *
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 *
 * 输入：matrix = [[1]]
 * 输出：1
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考：https://github.com/grandyang/leetcode/issues/329
 */
public class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int res = 1;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 剪枝
                if (dp[i][j] == 0) {
                    res = Math.max(res, dfs(matrix, dp, m, n, i, j));
                }
//                res = Math.max(res, dfs(matrix, dp, m, n, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int[][] dp, int m, int n, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int ret = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, dp, m, n, x, y);
            ret = Math.max(ret, len);
        }
        dp[i][j] = ret;
        return ret;
    }
}
