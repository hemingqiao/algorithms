package blogandquestion.algorithms.string.generateparenthesis22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/18 19:43:52
 * description: 利用深度优先遍历
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 */
public class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }

    private void dfs(int left, int right, String curStr) {
        // 当左右括号都不剩余了，结束递归
        if (left == 0 && right == 0) { // base case
            result.add(curStr);
            return;
        }

        // 如果左括号还有剩余的话，可以拼接左括号
        if (left > 0) {
            dfs(left - 1, right, curStr + "(");
        }

        // 如果右括号剩余数量多于左括号，可以拼接右括号
        if (right > left) {
            dfs(left, right - 1, curStr + ")");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.generateParenthesis(2);
        System.out.println(res);
    }
}
