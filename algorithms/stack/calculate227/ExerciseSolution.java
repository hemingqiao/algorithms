package blogandquestion.algorithms.stack.calculate227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/11 22:23:12
 * description:
 */
public class ExerciseSolution {
    // 参考：https://github.com/grandyang/leetcode/issues/227
    public int calculate(String s) {
        int res = 0, num = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        char op = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (t >= '0') {
                num = num * 10 + (t - '0');
            }
            if (t < '0' && t != ' ' || i == n - 1) {
                if (op == '+') stack.push(num);
                if (op == '-') stack.push(-num);
                if (op == '*' || op == '/') {
                    int temp = (op == '*') ? stack.pop() * num : stack.pop() / num;
                    stack.push(temp);
                }
                op = t;
                num = 0;
            }
        }
        for (int t : stack) {
            res += t;
        }
        return res;
    }
}
