package blogandquestion.algorithms.string.countsubstrings647;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/31 14:33:17
 * description:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 *
 */
public class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n][n];
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
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) res++;
            }
        }
        return res;
    }
}
