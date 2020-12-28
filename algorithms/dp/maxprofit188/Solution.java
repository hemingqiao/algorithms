package blogandquestion.algorithms.dp.maxprofit188;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/28 15:35:24
 * description:
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *  
 *
 * 提示：
 *
 * 0 <= k <= 10^9
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 *
 */
public class Solution {
//    public int maxProfit(int k, int[] prices) {
//        int n = prices.length;
//        if (k * 2 >= n) {
//            return quickMaxProfit(prices);
//        }
//        // dp[i][j] = 在第j天，最多i次交易的时候，可以获得的最大利润
//        int[][] dp = new int[k + 1][n + 1];
//        // 交易次数从1到k
//        for (int i = 1; i <= k; i++) {
//            int tempMax = -prices[0]; // 手上剩余的钱
//            // 天数从第1天到第n天
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = Math.max(dp[i][j - 1], tempMax + prices[i - 1]);
//                tempMax = Math.max(tempMax, dp[i - 1][j - 1] - prices[i - 1]);
//            }
//        }
//        return dp[k][n];
//    }


    /*
    dp[i][j] = 在第j天，最多i次交易的时候，可以获得的最大利润

    假设当前为第j天，有两种选项：
        1、什么也不做或者买入，此时的最大利润不会改变，dp[i][j] = dp[i][j-1]
        2、卖出股票，如果卖出代表你在[0...j-1]天中购买过股票，假设买入的时候为第t天，最大利润为 max(prices[j]-prices[t]+dp[i-1][t-1])

    参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iv-by-8xtkp/723265
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k * 2 >= n) {
            return quickMaxProfit(prices);
        }
        // dp[i][j] = 在第j天，最多i次交易的时候，可以获得的最大利润
        int[][] dp = new int[k + 1][n + 1];
        // 交易次数从1到k
        for (int i = 1; i <= k; i++) {
            // 卖出天数从第1天到第n天中的某一天，计算在某天卖出的最大利润
            for (int j = 1; j <= n; j++) {
                // 假设第j天卖出，那么第j天之前的任意一天都可以买入，计算哪天买入对应的利润最高
                for (int m = 1; m < j; m++) {
                    dp[i][j] = Math.max(prices[j - 1] - prices[m - 1] + dp[i - 1][m - 1], dp[i][j]);
                }
                // 再对比第一个选项中什么都不做的利润
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        }
        return dp[k][n];
    }

    private int quickMaxProfit(int[] prices) {
        int ret = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                ret += prices[i + 1] - prices[i];
            }
        }
        return ret;
    }
}
