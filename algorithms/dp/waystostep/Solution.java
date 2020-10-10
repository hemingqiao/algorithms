package blogandquestion.algorithms.dp.waystostep;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/10 15:44:09
 * description:
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 *
 * 解题思路：
 * 和爬楼梯问题类似。设dp[i]为爬上第i阶所有的方法数。
 * 又因为一次可以上1阶、2阶、3阶，所以有dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
 * 这里需要注意的是，在i-3阶时，可以上3阶到达i阶，也可以向上走1阶或者走2阶，但是走1阶到达i - 2阶这个方式已经包含在了dp[i - 2]中，
 * 而走2阶到达i - 1阶这个方式已经包含在了dp[i - 1]中，所以无需考虑在i - 3 阶走1阶或2阶的方式。同理对i - 2阶也是如此。
 */
public class Solution {
    public int waysToStep(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 4;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.waysToStep(5);
        System.out.println(result);
    }
}
