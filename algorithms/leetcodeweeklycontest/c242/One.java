package blogandquestion.algorithms.leetcodeweeklycontest.c242;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/23 11:54:53
 * description:
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 *
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：true
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："1101"
 * 由 0 组成的最长连续子字符串的长度是 1："1101"
 * 由 1 组成的子字符串更长，故返回 true 。
 * 示例 2：
 *
 * 输入：s = "111000"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 3："111000"
 * 由 0 组成的最长连续子字符串的长度是 3："111000"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 示例 3：
 *
 * 输入：s = "110100010"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s[i] 不是 '0' 就是 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros
 *
 */
public class One {
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        int a = 0, b = 0;
        int[][] dp = new int[n][2];
        if (s.charAt(0) == '1') {
            dp[0][1] = 1;
            a = 1;
        } else {
            dp[0][0] = 1;
            b = 1;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (s.charAt(i) == '1') {
                    dp[i][1] = dp[i - 1][1] + 1;
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                }
            } else {
                if (s.charAt(i) == '1') dp[i][1] = 1;
                else dp[i][0] = 1;
            }
            a = Math.max(a, dp[i][1]);
            b = Math.max(b, dp[i][0]);
        }
        return a > b;
    }

    /**
     * 这个解法真妙
     * 参考：https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros/solution/cpython3-1tong-ji-geng-xin-2hua-dong-chu-y124/
     *
     * @param s 待比较二进制字符串
     * @return
     */
    public boolean checkZeroOnes1(String s) {
        int res0 = 0, res1 = 0;
        int cur0 = 0, cur1 = 0;
        int n = s.length();
        // 使用cur0和cur1来更新res0和res1
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ++cur0;
                cur1 = 0;
            } else {
                ++cur1;
                cur0 = 0;
            }
            res0 = Math.max(res0, cur0);
            res1 = Math.max(res1, cur1);
        }
        return res1 > res0;
    }
}
