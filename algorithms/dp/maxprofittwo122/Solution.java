package blogandquestion.algorithms.dp.maxprofittwo122;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/09 21:04:42
 * description: 第122题动态规划解法
 * 暂时没理解啊
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size == 0)
            return 0;
        int[][] dp = new int[size][2];
        //dp[i][0]手里持有现金
        //dp[i][1]手里持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[size - 1][0];
    }
}
