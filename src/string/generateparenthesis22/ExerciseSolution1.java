package src.string.generateparenthesis22;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/16 22:50:04
 * description:
 */
public class ExerciseSolution1 {
    // see: https://www.acwing.com/video/1344/
    // 合法的括号序列条件
    // 任意前缀中，左括号的数量大于等于右括号的数量，才能是一个合法的括号序列
    // 左括号的数量等于右括号的数量
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    public void dfs(int n, int l, int r, StringBuilder s) {
        if (l == n && r == n) {
            res.add(s.toString());
            return;
        }
        if (l < n) {
            s.append('(');
            dfs(n, l + 1, r, s);
            s.deleteCharAt(s.length() - 1);
        }
        // 左括号数量需要大于右括号的数量，不能等于，如果等于，在拼上一个右括号，就不是合法的括号序列了
        if (r < n && l > r) {
            s.append(')');
            dfs(n, l, r + 1, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(0b10);
    }
}
