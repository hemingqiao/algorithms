package src.dp.maxprofit121;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 10:57:59
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 想不到其他办法时，可以尝试使用暴力破解
    // 但是这一题最后几个测试用例数据量特别大，暴力法会超时
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    // 找到数组中的最小值，判断每个元素和这个最小值的差值，最大的差值就是所求的最大利润
    // 需要用一个变量来记录最小值
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;
        for (int price : prices) {
            minVal = Math.min(minVal, price);
            maxProfit = Math.max(maxProfit, price - minVal);
        }
        return maxProfit;
    }

    // 重点理解这种动态规划的解法
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        // dp[i][0]表示第i天结束时，不持股，手头的现金数
        // dp[i][1]表示第i天结束时，持股，手头的现金数
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        // 题目限定，只能交易一次，也就是刚开始手头上现金数为0，只能进行一次交易，所以如果买入现金需要减去股票当天的价格
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 今天不持股可以由两种状态转移而来：昨天不持股、昨天持股，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持股也可以由两种状态转移而来：昨天持股，昨天不持股，今天持股
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
