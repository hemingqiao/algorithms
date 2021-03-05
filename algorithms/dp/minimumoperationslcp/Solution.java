package blogandquestion.algorithms.dp.minimumoperationslcp;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/05 14:21:19
 * description:
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 *
 * 提示：
 *
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/UlBDOe
 *
 * 参考：https://leetcode-cn.com/problems/UlBDOe/solution/ulbdoe-by-ikaruga/
 */
public class Solution {
    public int minimumOperations(String leaves) {
        char[] chars = leaves.toCharArray();
        int n = chars.length;
        int[][] dp = new int[3][n];
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (i < 1) {
                dp[0][i] = (t == 'y' ? 1 : 0);
            } else {
                dp[0][i] = dp[0][i - 1] + (t == 'y' ? 1 : 0);
            }

            if (i < 1) {
                dp[1][i] = dp[0][i];
            } else {
                dp[1][i] = Math.min(dp[0][i - 1] + (t == 'r' ? 1 : 0), dp[1][i - 1] + (t == 'r' ? 1 : 0));
            }

            // 注意这里的条件是 i < 2(不是很理解)
            // dp[2][0] == dp[0][0] == dp[1][0], 而dp[2][1] == dp[1][1]
            if (i < 2) {
                dp[2][i] = dp[1][i];
            } else {
                dp[2][i] = Math.min(dp[1][i - 1] + (t == 'y' ? 1 : 0), dp[2][i - 1] + (t == 'y' ? 1 : 0));
            }
        }
        return dp[2][n - 1];
    }
}
