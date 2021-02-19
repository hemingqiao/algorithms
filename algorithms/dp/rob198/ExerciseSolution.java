package blogandquestion.algorithms.dp.rob198;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/19 20:37:36
 * description:
 * 二刷，这题也是经典的二维动态规划题目
 */
public class ExerciseSolution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        // 二维dp数组，0代表今天不偷，1代表今天偷
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            // 今天不偷可以从两个状态转移而来：昨天不偷，昨天偷了，今天不偷
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 而今天偷只可能从一个状态转移而来：昨天不偷，今天偷，这是因为不能连着偷：昨天偷了，今天就不能偷了
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
