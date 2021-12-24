package blogandquestion.algorithms.stack.validparentheses20;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/06 21:56:10
 * description:
 */
public class ExerciseSolution1 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
