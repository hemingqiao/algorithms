package src.dp.minCostClimbingStairs746;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/10 15:08:39
 * description:
 *
 * 数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 *
 * 解题思路：
 * 令dp[i]为踏上i阶所需花费。因为一次可以爬一个阶梯或者爬两个阶梯。所以踏上第i阶可以从i - 2阶爬两个阶梯，也可以从i - 1阶爬一个阶梯。
 * 所以踏上i阶的最小花费是 dp[i] = min(dp[i - 2], dp[i - 1]) + cost[i];
 * 上式即为状态转移方程。
 * 而踏上i阶顶部可以从第i阶向上走1阶，也可以从i - 1阶向上走2阶，所以求出走到i - 1阶和i阶之间消耗的最小值即可。
 * see: https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 注意到上面的状态转移方程只用到了前面两个记录，可以不同一维数组，只用两个变量保存前面的两个记录，并不断更新，就可以递推下去。
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairsOpt(int[] cost) {
        int p0 = cost[0];
        int p1 = cost[1];
        int temp = 0;
        for (int i = 2; i < cost.length; i++) {
            temp = Math.min(p0, p1) + cost[i];
            p0 = p1;
            p1 = temp;
        }
        return Math.min(p0, p1);
    }

    /**
     * 更进一步，注意到初始值dp[0] = cost[0]，dp[1] = cost[1]，可以直接复用cost数组来代表dp数组。
     *
     * @param cost
     * @return
     */
    public int minCost(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
