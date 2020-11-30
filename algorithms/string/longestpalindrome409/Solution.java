package blogandquestion.algorithms.string.longestpalindrome409;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 08:39:01
 * description:
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 *
 */
public class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 1) return 1;
        int[] record = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            record[c]++;
        }
        int res = 0;
        boolean flag = false; // 标识是否出现了奇数个字符
        for (int i = 0; i < record.length; i++) {
            if (record[i] >= 2) {
                res += record[i] / 2 * 2;
            }
            if ((record[i] & 1) == 1) {
                // 如果是奇数
                flag = true;
            }
        }
        if (flag) return res + 1;
        return res;
    }
}
