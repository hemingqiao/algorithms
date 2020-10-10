package blogandquestion.algorithms.greedy.issubsequence392;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/10 16:02:36
 * description: 自己写的暴力解法，竟然时间0ms，超过了100%😆
 * 题目描述：
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 *
 */
public class MySolution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 ) return true;

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int index = 0;
        char c = charS[index];
        for (int i = 0; i < charT.length; i++) {
            if (c == charT[i]) {
                index++;
                if (index >= charS.length) {
                    return true;
                }
                c = charS[index];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MySolution ms = new MySolution();
        boolean res = ms.isSubsequence("axc", "ahbgdc");
        System.out.println(res);
    }


    /**
     * 使用indexOf 方法进行优化
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubSequenceOpt(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }
}
