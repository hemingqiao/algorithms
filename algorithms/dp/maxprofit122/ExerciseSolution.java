package blogandquestion.algorithms.dp.maxprofit122;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 11:20:07
 * description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
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

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        int res = 0;
        dp[0][0] = 0; // dp[i][0]代表今天不持股手上的现金数
        dp[0][1] = -prices[0]; // dp[i][1]代表今天持股手上的现金数
        for (int i = 1; i < n; i++) {
            // 第i天不持股可以由两种状态转移而来：第i - 1天不持股，或者是第i - 1天持股，i天卖出，取这两种状态中现金数较大的方案
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持股也可以有两种状态转移而来：第i - 1天持股，或者是i - 1天不持股，i天买入，取这两种状态中现金数较大的方案
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
