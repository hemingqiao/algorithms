package blogandquestion.algorithms.dp.lcs.longestcommonsubsequence1143;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/03 20:41:49
 * description:
 */
public class ExerciseSolution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
        int n1 = chars1.length, n2 = chars2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (chars1[i] == chars2[j]) {
                    // 如果两个字符相等，则该状态dp[i + 1][j + 1]可以由其子问题转移而来，即考察dp[i][j]，然后加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    // 如果两个字符不等，dp[i + 1][j + 1]的状态可以由[i][j + 1]和[i + 1][j]转移而来
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}
