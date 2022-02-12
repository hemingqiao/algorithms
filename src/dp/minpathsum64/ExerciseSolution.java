package src.dp.minpathsum64;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/04 13:40:56
 * description:
 */
public class ExerciseSolution {
    // 动态规划经典题目，当非第一行和第一列时，当前状态只会由两种状态转移而来：从上面或者从左面
    // 而对第一行和第一列特殊处理
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
