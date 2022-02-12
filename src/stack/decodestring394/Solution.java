package src.stack.decodestring394;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/06 19:40:32
 * description:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 *
 * 参考：https://github.com/grandyang/leetcode/issues/394
 */
public class Solution {
    private int i = 0;
    public String decodeString(String s) {
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        while (i < n && s.charAt(i) != ']') {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                ret.append(s.charAt(i++));
            } else {
                int cnt = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    cnt = cnt * 10 + (s.charAt(i++) - '0');
                }
                ++i; // 跳过左中括号
                String t = decodeString(s);
                ++i; // 跳过右中括号
                while (cnt-- > 0) {
                    ret.append(t);
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "3[a]2[bc]";
        String res = s.decodeString(test);
        System.out.println(res);
    }
}
