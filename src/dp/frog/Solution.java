package src.dp.frog;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/04 22:14:44
 * description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 */
public class Solution {
    // 这题和爬楼梯类似，需要注意的一点是结果对1e9 + 7取模
    // 而如果取模会决定代码能不能AC，如果在最后才取模，会导致溢出，需要在运算过程中就进行取模
    public int numWays(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % ((int) 1e9 + 7); // 要在这里就进行取模运算，否则后续运算可能溢出
        }
        return dp[n];
    }

    // Fibonacci数列解法
    public int numWays1(int n) {
        int a = 1, b = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (a + b) % ((int) 1e9 + 7);
            a = b;
            b = ans;
        }
        return ans;
    }
}
