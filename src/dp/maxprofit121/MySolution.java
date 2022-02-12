package src.dp.maxprofit121;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/29 21:57:54
 * description:
 * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 */
public class MySolution {
    // 还不是很理解
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数
        int[][] dp = new int[len][2];
        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 今天不持股可能由两种状态转移而来：昨天不持股，或者昨天持股，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持股也可能由两种状态转移而来：昨天持股，昨天不持股，今天买入
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}

class ThirdSolution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int maxProfit = 0;
        int maxCur = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, prices[i] - prices[i - 1] + maxCur);
            maxProfit = Math.max(maxProfit, maxCur);
        }
        return maxProfit;
    }

    public int maxProfitOpt(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE; // 定义一个最小值
        if (prices.length < 2) return 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                res = Math.max(res, prices[i] - min);
            } else {
                // 如果prices[i] <= min，min更新为prices[i]的值
                min = prices[i];
            }
        }
        return res;
    }
}
