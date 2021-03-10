package blogandquestion.algorithms.stack.calculate224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/10 22:28:19
 * description:
 */
public class ExerciseSolution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (t >= '0') {
                int temp = t - '0';
                int j = i + 1;
                while (j < n && chars[j] >= '0') {
                    temp = temp * 10 + (chars[j++] - '0');
                    i++;
                }
                res += sign * temp;
            } else if (t == '-') {
                sign = -1;
            } else if (t == '+') {
                sign = 1;
            } else if (t == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (t == ')') {
                res *= stack.pop();
                res += stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "2147483647";
        int res = es.calculate(test);
        System.out.println(res);
    }
}
