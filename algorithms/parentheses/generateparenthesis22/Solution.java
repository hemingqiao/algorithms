package blogandquestion.algorithms.parentheses.generateparenthesis22;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/12 10:50:46
 * description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 */
public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void dfs(int n, int lc, int rc, StringBuilder s) {
        if (lc == n && rc == n) ans.add(s.toString());
        else  {
            if (lc < n) {
                s.append('(');
                dfs(n, lc + 1, rc, s);
                s.deleteCharAt(s.length() - 1);
            }
            if (rc < n && lc > rc) {
                s.append(')');
                dfs(n, lc, rc + 1, s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
}
