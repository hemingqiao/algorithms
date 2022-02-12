package src.numbers.integerbreak343;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 13:03:21
 * description:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 *
 * 参考：https://leetcode-cn.com/problems/integer-break/solution/shu-xue-zhi-shi-he-dong-tai-gui-hua-liang-chong-2/
 */
public class Solution {
    public int integerBreak(int n) {
        // n <= 4时特判
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            // 如果n大于4，不停的减去3
            n -= 3;
            // 将3与结果相乘
            res *= 3;
        }
        return res * n;
    }
}
