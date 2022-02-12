package src.parentheses.checkvalidstring678;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/12 10:20:22
 * description:
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 *     任何左括号 ( 必须有相应的右括号 )。
 *     任何右括号 ) 必须有相应的左括号 ( 。
 *     左括号 ( 必须在对应的右括号之前 )。
 *     * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 *     一个空字符串也被视为有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 *
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 *
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 *
 * 注意:
 *
 *     字符串大小将在 [1，100] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 *
 */
public class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else {
                low--;
                high++;
            }
            low = Math.max(low, 0);
            if (low > high) return false;
        }
        return low == 0;
    }
}
