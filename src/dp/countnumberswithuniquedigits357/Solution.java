package src.dp.countnumberswithuniquedigits357;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 21:39:12
 * description:
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 *
 *
 * 参考：https://leetcode-cn.com/problems/count-numbers-with-unique-digits/solution/zhi-xing-yong-shi-0-ms-zai-suo-you-java-ti-jia-433/
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/solution/dong-tai-gui-hua-la-by-jxjxhc-2/
 *
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int sum = 10;
        int min = Math.min(10, n);
        for (int i = 1; i < min; i++) {
            dp[i + 1] = dp[i] * (10 - i);
            sum += dp[i + 1];
        }
        return sum;
    }
}
