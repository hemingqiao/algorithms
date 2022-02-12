package src.dp.rob213;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/20 13:23:28
 * description:
 * 二刷
 * 经典的二维动态规划
 */
public class ExerciseSolution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(help(nums, 0, n - 1), help(nums, 1, n));
    }

    public int help(int[] nums, int start, int end) {
        // 二维dp数组，0代表当天不偷，1代表当天偷
        int[][] dp = new int[end][2];
        dp[start][0] = 0;
        dp[start][1] = nums[start];
        for (int i = start + 1; i < end; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[end - 1][0], dp[end - 1][1]);
    }
}
