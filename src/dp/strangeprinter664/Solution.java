package src.dp.strangeprinter664;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/24 21:18:01
 * description:
 */
public class Solution {
    // 不理解
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = i == j ? 1 : (1 + dp[i + 1][j]);
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k][j]);
                    }
                }
            }
        }
        return (n == 0) ? 0 : dp[0][n - 1];
    }
}
