package blogandquestion.algorithms.dp.maxprofit309;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 14:58:00
 * description:
 * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
 */
public class AnotherSolution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = 0; // 不持股，且当天没有卖出
        dp[0][1] = -prices[0]; // 当天持股
        dp[0][2] = 0; // 不持股，且当天卖出了股票
        for (int i = 1; i < n; i++) {
            // 第i天不持股，且没有卖出可以由两种状态转移而来：i-1天不持股，且没有卖出；i-1天不持股，有卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 第i天持股，可以由两种状态转移而来：i-1天持股；i-1天不持股，且没有卖出，第i天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第i天不持股，且第i天卖出了股票，只能由第i-1天持有股票转移而来
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}
