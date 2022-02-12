package src.string.generateparenthesis22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/20 19:09:43
 * description:
 * 参考：https://mp.weixin.qq.com/s/Ikwz2HQy3IWNe56GUFws4A
 */
public class AnotherSolution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    private void dfs(List<String> res, int left, int right, String str) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left < 0) return; // 已经没有左括号可选，左括号数量最小为0
        if (right < left) return; // 右括号的数量小于左括号，非法
        dfs(res, left - 1, right, str + "("); // 选择左括号
        dfs(res, left, right - 1, str + ")"); // 选择右括号
    }

    public static void main(String[] args) {
        List<String> res = new Solution().generateParenthesis(2);
        System.out.println(res);
    }
}
