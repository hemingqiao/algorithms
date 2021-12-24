package blogandquestion.algorithms.dp.maxprofit309;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 14:43:23
 * description:
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 *
 * 参考：https://leetcode-cn.com/circle/article/qiAgHn/
 * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        // dp[i][0]表示第i天结束时，不持股，手头的现金，初始现金（启动资金）为0
        // dp[i][1]表示第i天结束时，持股，手头的现金数
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 初始资金为0
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 第i天不持股，可以由以下两个状态转移而来：第i-1天不持股，第i-1天持股，第i天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持股，可以由以下两个状态转移而来：1、第i-1天持股；2、之前不持股，第i天买入
            // 又因为卖出股票之后存在冷冻期（一天），冷冻期内不能买入股票，所以第二种情况是由i-2天不持股，第i天买入转移而来
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }
        return dp[n - 1][0];
    }
}
