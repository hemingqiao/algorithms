package blogandquestion.algorithms.dp.coinchange322;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/03 20:39:53
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/322
 */
public class ExerciseSolution {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示钱数为i时所需的最少硬币数
        int[] dp = new int[amount + 1];
        // dp[0]初始化为0，钱数为0时不需要找零
        dp[0] = 0;
        // 硬币面额最小为1，所以钱数为i时找零的硬币数最大为i，将dp数组其他值初始化为i + 1
        Arrays.fill(dp, 1, amount + 1, amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 目标值为11，假如取了一个5元的硬币，如果知道dp[6]，就可以比较出组成11的dp值了
                // 但是硬币的面额应该小于等于目标值，比如不能拿5元的硬币来更新dp[3]
                // 更新dp[11]时，遍历了所有小于等于amount的硬币面额，因为dp[11]可以由dp[10], dp[9], dp[6]转移而来（面额1、2、5）
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        es.coinChange(new int[]{0}, 6);
    }
}
