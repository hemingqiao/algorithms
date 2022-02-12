package src.dp.climbstairs70;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 09:23:35
 * description: 使用动态规划
 * 动态规划是自底向上解决原问题。比如在这里，要爬到第n级台阶，从第0级开始，可以爬1级，也可以爬2级，如果爬1级，则剩下n-1级要爬，
 * 如果爬2级，剩下n-2级要爬，这就分出了两个字问题：爬n-1级和爬n-2级有多少种方法。
 * 动态规划会迭代的将结果记忆下来，存在数组里。
 * see: https://leetcode-cn.com/problems/climbing-stairs/solution/cong-zhi-jue-si-wei-fen-xi-dong-tai-gui-hua-si-lu-/
 */
public class DP {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
