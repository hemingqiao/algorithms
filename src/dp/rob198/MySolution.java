package src.dp.rob198;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/29 21:24:07
 * description:
 */
public class MySolution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[][] dp = new int[len][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            // 今天只和昨天的状态相关，依然是分类讨论：
            // 今天不接受预约：或者是昨天不接受预约，或者是昨天接受了预约，取二者最大值，即：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])；
            // 今天接受预约：只需要从昨天不接受预约转移而来，加上今天的时常，即：dp[i][1] = dp[i - 1][0] + nums[i]。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
