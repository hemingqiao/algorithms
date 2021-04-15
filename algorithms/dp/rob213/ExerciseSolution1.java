package blogandquestion.algorithms.dp.rob213;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/15 13:30:09
 * description:
 */
public class ExerciseSolution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
    }

    public int rob(int[] nums, int start, int end) {
        // 二维数组，dp[i][0]表示不偷第i间，dp[i][1]表示偷第i间
        int[][] dp = new int[end - start][2];
        int n = end - start;
        dp[0][0] = 0;
        dp[0][1] = nums[start];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i + start];
        }
        // 注意这里还需要比较下最后一间房子偷还是不偷的值那个大，因为一间房子有两个状态
        return Math.max(dp[n - 1][1], dp[n - 1][0]);
    }
}
