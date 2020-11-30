package blogandquestion.algorithms.dp.maxprofit123;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 13:33:00
 * description:
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 *
 * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/xiao-bai-tong-su-yi-dong-de-jie-fa-by-clark-12/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int maxProfit2 = 0;
        for (int price : prices) {
            buy1 = Math.min(price, buy1);
            maxProfit1 = Math.max(maxProfit1, price - buy1);
            // 第二次买入时，使用了第一次卖出时赚到的钱
            // 所以第二次买入的成本是当前买入价格减去第一次卖出赚到的钱之差
            buy2 = Math.min(buy2, price - maxProfit1);
            maxProfit2 = Math.max(maxProfit2, price - buy2);
        }
        return maxProfit2;
    }
}
