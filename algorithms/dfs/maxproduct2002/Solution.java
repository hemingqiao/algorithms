package blogandquestion.algorithms.dfs.maxproduct2002;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/14 20:47:29
 * description:
 * 给你一个字符串 s ，请你找到 s 中两个 不相交回文子序列 ，使得它们长度的 乘积最大 。两个子序列在原字符串中如果没有任何相同下标的字符，则它们是 不相交 的。
 *
 * 请你返回两个回文子序列长度可以达到的 最大乘积 。
 *
 * 子序列 指的是从原字符串中删除若干个字符（可以一个也不删除）后，剩余字符不改变顺序而得到的结果。如果一个字符串从前往后读和从后往前读一模一样，那么这个字符串是一个 回文字符串 。
 *
 * 示例 1：
 *
 * 输入：s = "leetcodecom"
 * 输出：9
 * 解释：最优方案是选择 "ete" 作为第一个子序列，"cdc" 作为第二个子序列。
 * 它们的乘积为 3 * 3 = 9 。
 *
 * 示例 2：
 *
 * 输入：s = "bb"
 * 输出：1
 * 解释：最优方案为选择 "b" （第一个字符）作为第一个子序列，"b" （第二个字符）作为第二个子序列。
 * 它们的乘积为 1 * 1 = 1 。
 *
 * 示例 3：
 *
 * 输入：s = "accbcaxxcxx"
 * 输出：25
 * 解释：最优方案为选择 "accca" 作为第一个子序列，"xxcxx" 作为第二个子序列。
 * 它们的乘积为 5 * 5 = 25 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences
 *
 */
public class Solution {
    int ans = 0;
    int n;
    String ss;

    public int maxProduct(String s) {
        n = s.length();
        ss = s;
        dfs(new StringBuilder(), new StringBuilder(), 0);
        return ans;
    }

    public void dfs(StringBuilder s1, StringBuilder s2, int p) {
        if (check(s1) && check(s2)) ans = Math.max(ans, s1.length() * s2.length());
        if (p == n) return;
        char t = ss.charAt(p);
        dfs(s1.append(t), s2, p + 1);
        s1.deleteCharAt(s1.length() - 1);
        dfs(s1, s2.append(t), p + 1);
        s2.deleteCharAt(s2.length() - 1);
        dfs(s1, s2, p + 1);
    }

    public boolean check(StringBuilder s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
