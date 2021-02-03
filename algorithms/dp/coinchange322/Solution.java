package blogandquestion.algorithms.dp.coinchange322;


import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/02 13:35:52
 * description:
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 *
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        // dp[n]的值：表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 包含当前的 coin，那么剩余钱就是 i-coin，这种操作要兑换的硬币数是 dp[i-coin] + 1
                if (i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {186, 419, 83, 408};
        int res = s.coinChange(coins, 6249);
        System.out.println(res);
    }
}


/**
 * dfs搜索
 * 参考：https://leetcode-cn.com/problems/coin-change/solution/dfsjian-zhi-2ms-ji-bai-100bi-dphuan-kuai-by-iejepw/
 */
class AnotherSolution {
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); // 先对数组升序排序
        dfs(coins, coins.length - 1, amount, 0); // 从面额最大的硬币开始查找
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[] coins, int index, int amount, int count) {
        if (index < 0) {
            // 硬币已经用完，退出
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int left = amount - c * coins[index]; // 距离amount还差多少钱
            int usedCoins = count + c; // 已经使用过的硬币数
            if (left == 0) {
                // 当 left == 0 时剪枝，因为大面值硬币需要更多小面值硬币替换，继续减少一枚或几枚大硬币搜索出来的答案【如果有】肯定不会更优
                ans = Math.min(ans, usedCoins);
                break;
            }
            if (usedCoins + 1 >= ans) {
                // 当 left != 0，但已经使用的硬币数 usedCoins 满足了 usedCoins + 1 >= ans 时剪枝，因为 left 不为 0，
                // 至少还要使用 1 枚硬币，那么继续搜索得到的答案不会更优。注意是 break 不是 continue，因为少用几枚面值大的硬币
                // 搜索出的方案【如果有】肯定需要更多枚面值小的硬币来替换掉这枚大的硬币，而使用这几枚大的硬币都搜索不到更好的解，
                // 所以应该是 break
                break;
            }
            // 如果没有退出循环，使用面额较小的硬币继续进行递归查找
            dfs(coins, index - 1, left, usedCoins);
        }
    }
}
