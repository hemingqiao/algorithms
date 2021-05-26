package blogandquestion.algorithms.string.reverseParentheses1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/27 13:26:58
 * description:
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 *
 */
public class Solution {
    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) return "";
        Deque<Character> stack = new ArrayDeque<>();
        int p = 0;
        while (p < n) {
            if (chars[p] == '(') {
                stack.push(')');
            } else if (chars[p] == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != ')') {
                    sb.append(stack.pop());
                }
                stack.pop();
                int i = 0, t = sb.length();
                while (i < t) {
                    stack.push(sb.charAt(i++));
                }
            } else {
                stack.push(chars[p]);
            }
            p++;
        }
        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            ret.append(stack.pop());
        }
        return ret.reverse().toString();
    }
}
