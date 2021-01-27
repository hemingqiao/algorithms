package blogandquestion.algorithms.dp.maxsubarray53;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/27 21:07:28
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i + 1]代表以nums[i]结尾的最大连续子数组之和，如果dp[i]小于零，那么对dp[i + 1]是没有任何增益的，所以需要舍弃
            // 如果dp[i]大于等于0，是可以对dp[i + 1]有增益的，此时nums[i]需要加上dp[i]
            dp[i + 1] = dp[i] < 0 ? nums[i] : dp[i] + nums[i];
            maxSum = Math.max(maxSum, dp[i + 1]);
        }
        return maxSum;
    }
}
