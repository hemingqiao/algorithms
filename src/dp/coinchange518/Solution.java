package src.dp.coinchange518;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/10 21:27:07
 * description:
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 *
 */
public class Solution {
    public int change(int amount, int[] coins) {
        // 可以转化为完全背包问题
        // 将f[i][j]定义为考虑前i个硬币，组成总和为j的方案总数
        // 则所求就是f[n][m]
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                // 这个状态的转移还是不太懂
                if (j >= coins[i - 1]) f[i][j] = Math.max(f[i][j], f[i][j - coins[i - 1]] + f[i - 1][j]);
            }
        }
        return f[n][amount];
    }
}
