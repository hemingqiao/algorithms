package blogandquestion.algorithms.dp.lcs.longestcommonsubsequence1143;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/18 20:56:16
 * description:
 * 这道题是典型的二维动态规划
 */
public class AnotherSolution {
    // 参考：https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-tu-wen-jie-xi-by-yijiaoqian/
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
        int m = chars1.length, n = chars2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
