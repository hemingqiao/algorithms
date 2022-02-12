package src.stack.validparentheses20;

import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/18 14:44:31
 * description: 利用栈。
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 *
 * 解题思路
 * see: https://leetcode.wang/leetCode-20-Valid%20Parentheses.html
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    bracket.push(c);
                    break;
                case ')':
                    if (!bracket.empty()) {
                        if (bracket.pop() == '(') {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                case ']':
                    if (!bracket.empty()) {
                        if (bracket.pop() == '[') {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                case '}':
                    if (!bracket.empty()) {
                        if (bracket.pop() == '{') {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
            }
        }
        return bracket.empty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "[]()";
        boolean result  =s.isValid(s1);
        System.out.println(result);
    }
}
