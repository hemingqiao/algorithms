package blogandquestion.algorithms.dp.maxprofittwo122;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 12:52:04
 * description:
 */
public class GreedySolution {
    // 假如第0天买入，第2天卖出，可以获得最大利润
    // 可以分解为 prices[2] - prices[0] = (prices[2] - prices[1]) + (prices[1] - prices[0])
    // 将每天和前一天相减，得到正值就加到利润上
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return maxProfit;
    }
}
