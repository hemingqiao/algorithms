package blogandquestion.algorithms.string.generateparenthesis22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/19 20:25:30
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 回溯算法
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, n, n, "");
        return list;
    }

    public void backtrack(List<String> list, int left, int right, String s) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
        if (left > 0) backtrack(list, left - 1, right, s + "(");
        if (right > left) backtrack(list, left, right - 1, s + ")");
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        List<String> res = es.generateParenthesis(3);
        System.out.println(res);
    }
}
