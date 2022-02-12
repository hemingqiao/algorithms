package src.dp.mincut132;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/08 21:48:18
 * description:
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 *
 */
public class Solution {
    // 参考：https://github.com/grandyang/leetcode/issues/132
    public int minCut(String s) {
        if (s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] p = new boolean[n][n];
        int[] dp = new int[n]; // dp[i]表示子串[0, i]内的最小分割次数
        for (int i = 0; i < n; i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                // i - j <= 2时，[i, j]内最多含有三个字符，而又有chars[i] == chars[j]，所以[i, j]内一定是回文
                if (chars[i] == chars[j] && (i - j <= 2 || p[j + 1][i - 1])) {
                    p[j][i] = true;
                    // 如果子串[j, i]内为回文，此时dp[i]就可以用 dp[j - 1] + 1 来更新了
                    // 要注意j此时不能等于0，一方面是j == 0会导致数组下标越界，另一方面，如果j == 0的话
                    // 说明字串[j, i]即[0, i]内为回文，而[0, 0]内肯定也是回文，此时无需分割，也即分割次数dp[i] = 0
                    dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
