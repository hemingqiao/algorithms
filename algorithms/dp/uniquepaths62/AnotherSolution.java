package blogandquestion.algorithms.dp.uniquepaths62;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/06 18:46:04
 * description:
 */
public class AnotherSolution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0];
        }
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        int result = as.uniquePaths(7, 3);
        System.out.println(result);
    }
}
