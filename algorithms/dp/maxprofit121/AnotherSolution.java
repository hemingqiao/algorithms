package blogandquestion.algorithms.dp.maxprofit121;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/08 21:07:18
 * description: 使用暴力解法
 *
 * see: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 */
public class AnotherSolution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            }
        }

        return maxProfit;
    }

    public int maxProfitOpt(int[] prices) {
        if (prices == null || prices.length <= 2) {
            return 0;
        }

        int maxProfit = 0;
        int minVal = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }

        return maxProfit;
    }
}
