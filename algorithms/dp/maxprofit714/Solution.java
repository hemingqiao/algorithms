package blogandquestion.algorithms.dp.maxprofit714;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/17 09:14:09
 * description:
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 *
 * 参考：https://github.com/grandyang/leetcode/issues/714
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int size = prices.length;
        if (size == 0) return 0;
        int[] hold = new int[size]; // hold数组表示第i天保留手中的股票此时的最大利润，hold数组还可以理解为第i天手头上剩余的钱
        int[] sold = new int[size]; // sold数组表示第i天卖掉股票此时的最大利润
        hold[0] = -prices[0]; // 第0天保留股票意味着花费-prices[0]的钱买入股票，因为是第一天，之前都没有持有股票，而sold[0]
        for (int i = 1; i < size; i++) {
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee); // i-1天时手头上的钱加上i天卖出的利润减去手续费
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
        }
        return sold[size - 1];
    }
}
