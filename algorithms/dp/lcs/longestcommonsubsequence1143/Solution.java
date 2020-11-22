package blogandquestion.algorithms.dp.lcs.longestcommonsubsequence1143;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/22 09:39:16
 * description:
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 *
 * 参考：https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-tu-wen-jie-xi-by-yijiaoqian/
 * https://leetcode-cn.com/problems/longest-common-subsequence/solution/a-fei-xue-suan-fa-zhi-by-a-fei-8/
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // 让索引为0的行和列表示空串，dp[0][x]和dp[y][0]都应该初始化为0，对应base case
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    // 当c1==c2,说明这两个字符是公共的字符，只要考察其子问题，dp[i][j]的长度即可，在此基础上+1
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    // 当c1!=c2,说明这两个字符不是公共的字符，只要考察其两个子问题，dp[i+1][j],dp[i][j+1],取两者之中的较大值
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
