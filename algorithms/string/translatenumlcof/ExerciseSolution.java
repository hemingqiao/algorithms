package blogandquestion.algorithms.string.translatenumlcof;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/04 21:30:12
 * description:
 */
public class ExerciseSolution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 当没有数字时翻译方案为1
        dp[1] = 1; // 只有一个数字时翻译方案也为1
        for (int i = 1; i < n; i++) {
            dp[i + 1] = dp[i];
            // 当前一个字符以1开头或者以2开头且当前字符小于等于5时，i + 1处的状态还可以从i - 1处转移而来
            if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2' && str.charAt(i) < '6') {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }
}
