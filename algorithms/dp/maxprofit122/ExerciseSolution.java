package blogandquestion.algorithms.dp.maxprofit122;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 11:20:07
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]表示第i天结束时，不持股，手头的现金数
        // dp[i][1]表示第i天结束时，持股，手头的现金数
        int[][] dp = new int[n][2];
        // 初始化，刚开始手头现金为0，第一次买入手头现金数需要减去股票价格
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 今天不持股可以由两种状态转移而来：昨天不持股，昨天持股，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持股也可以由两种状态转移而来：昨天持股，昨天不持股，今天买入
            // 由于交易次数不限，所以昨天不持股，今天买入这种状态对应于昨天不持股时手头现金减去今天买入花去的钱
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
