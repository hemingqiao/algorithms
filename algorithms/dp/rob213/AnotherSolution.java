package blogandquestion.algorithms.dp.rob213;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/29 21:32:11
 * description:
 */
public class AnotherSolution {
    // 可以与rob198，masseuselcci一起理解
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        // 房屋围成一圈说明nums[0]和nums[len - 1]不能同时偷，可以分为[0, len - 2] 和 [1, len - 1]两种情况求解，
        // 然后在比较这两种情况的最大值
        return Math.max(rob(nums, 0, len - 1), rob(nums, 1, len));
    }

    // 左闭右开区间，start可以取到，end取不到
    public int rob(int[] nums, int start, int end) {
        int[][] dp = new int[end][2];
        dp[start][0] = 0;
        dp[start][1] = nums[start];
        for (int i = start + 1; i < end; i++) {
            // i不偷可以从i - 1不偷和i - 1偷转移过来，所以需要比较二者的大小
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // i偷则是从i - 1不偷转移过来，i - 1偷不能转移到i偷
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[end - 1][0], dp[end - 1][1]);
    }
}
