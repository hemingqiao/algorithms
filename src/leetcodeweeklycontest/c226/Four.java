package src.leetcodeweeklycontest.c226;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/31 14:10:25
 * description:
 * 给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
 *
 * 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcbdd"
 * 输出：true
 * 解释："abcbdd" = "a" + "bcb" + "dd"，三个子字符串都是回文的。
 * 示例 2：
 *
 * 输入：s = "bcbddxy"
 * 输出：false
 * 解释：s 没办法被分割成 3 个回文子字符串。
 *  
 *
 * 提示：
 *
 * 3 <= s.length <= 2000
 * s​​​​​​ 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-iv
 *
 * 参考：https://leetcode-cn.com/circle/discuss/eGjGvo/view/iPoyQc/
 */
public class Four {
    public boolean checkPartitioning(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n][n];
        // 用中心扩展法以O(N^2)的时间复杂度找出所有回文串
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && chars[l] == chars[r]) {
                dp[l][r] = true;
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && chars[l] == chars[r]) {
                dp[l][r] = true;
                l--;
                r++;
            }
        }
        for (int i = 0; i + 2 < n; i++) {
            for (int j = i + 1; j + 1 < n; j++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
