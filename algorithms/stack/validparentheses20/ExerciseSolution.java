package blogandquestion.algorithms.stack.validparentheses20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/19 19:18:00
 * description:
 */
public class ExerciseSolution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    // 如果遇到了一个反括号而栈已经空了，表明字符串是不符合要求的
                    // 如果此时栈非空，而栈顶字符与当前字符不匹配，也表明字符串不符合要求
                    if (stack.isEmpty() || stack.peek() != c) {
                        return false;
                    }
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        // 使用Stack类反而比使用ArrayDeque类快上一些😅
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.peek() != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "()";
        ExerciseSolution es = new ExerciseSolution();
        boolean res = es.isValid(test);
        System.out.println(res);
    }
}
