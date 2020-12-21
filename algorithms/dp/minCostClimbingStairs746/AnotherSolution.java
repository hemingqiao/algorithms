package blogandquestion.algorithms.dp.minCostClimbingStairs746;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/21 09:03:32
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/746
 */
public class AnotherSolution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[len];
    }
}
