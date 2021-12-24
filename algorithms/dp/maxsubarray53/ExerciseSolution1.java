package blogandquestion.algorithms.dp.maxsubarray53;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/17 09:37:27
 * description:
 */
public class ExerciseSolution1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (i > 0) dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
