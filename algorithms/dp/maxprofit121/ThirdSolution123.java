package blogandquestion.algorithms.dp.maxprofit121;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 14:02:48
 * description:
 */
public class ThirdSolution123 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
