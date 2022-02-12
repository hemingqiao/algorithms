package src.dp.minpathsum64;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 17:30:47
 * description:
 */
public class AnotherSolution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // 行数
        int n = grid[0].length; // 列数
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 初始化第一行
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
