package blogandquestion.algorithms.dp.longestpalindrome5;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/08 21:23:33
 * description: 经典的二维动态规划问题
 */
public class ExerciseSolution1 {
    /*
    维护一个二维数组 dp，其中 dp[i][j] 表示字符串区间 [i, j] 是否为回文串，当 i = j 时，只有一个字符，肯定是回文串，如果 i = j + 1，
    说明是相邻字符，此时需要判断 s[i] 是否等于 s[j]，如果i和j不相邻，即 i - j >= 2 时，除了判断 s[i] 和 s[j] 相等之外，
    dp[i + 1][j - 1] 若为真，就是回文串，通过以上分析，可以写出递推式如下：

        dp[i, j] = 1                                               if i == j

                 = s[i] == s[j]                                    if j = i + 1

                 = s[i] == s[j] && dp[i + 1][j - 1]                if j > i + 1
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) return "";
        boolean[][] dp = new boolean[n][n];
        int left = 0, len = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (i - j == 1) {
                    dp[j][i] = chars[i] == chars[j];
                } else if (i - j > 1) {
                    dp[j][i] = chars[i] == chars[j] && dp[j + 1][i - 1];
                }
                if (dp[j][i] && len < i - j + 1) {
                    len = i - j + 1;
                    left = j;
                }
            }
        }
        return s.substring(left, left + len);
    }
}
