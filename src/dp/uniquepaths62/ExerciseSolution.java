package src.dp.uniquepaths62;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/24 13:12:39
 * description:
 */
public class ExerciseSolution {
    // solution 1
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i ==0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // solution 2
    // 优化空间，从上面解法可以观察出，第一行和第一列的值都是1，除此外，当前状态之和上方和左方状态有关
    // 可以压缩为一个一维的数组，一行一行的刷新
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
