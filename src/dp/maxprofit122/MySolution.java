package src.dp.maxprofit122;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/10 09:08:13
 * description: 自己想出来的dp解法。
 * dp[i]表示第i天可以获得的最大收益，只要当今天价格比昨天高，就可以卖出，获得截止到今天的最大利润。
 * 此时状态转移方程为 dp[i + 1] = dp[i] + prices[i + 1] - prices[i];
 * 否则dp[i + 1] = dp[i];
 */
public class MySolution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                dp[i + 1] = dp[i] + prices[i + 1] - prices[i];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        MySolution ms = new MySolution();
        int result = ms.maxProfit(test);
        System.out.println(result);
    }
}
