package src.dp.longestpalindrome5;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/26 22:10:10
 * description:
 */
public class ExerciseSolution2 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) return "";
        // dp[i][j]表示序列[i, j]代表的字符串是否是回文串
        boolean[][] dp = new boolean[n][n];
        int left = 0, len = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (i - j == 1) {
                    dp[i][j] = chars[i] == chars[j];
                } else if(i - j > 1) {
                    dp[i][j] = chars[i] == chars[j] && dp[i - 1][j + 1];
                }
                if (dp[i][j] && i - j + 1 > len) {
                    len = i - j + 1;
                    left = j;
                }
            }
        }
        return s.substring(left, left + len);
    }
}
