package src.parentheses.isvalid20;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/12 10:21:01
 * description:
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] q = s.toCharArray();
        int n = q.length;
        for (int i = 0; i < n; i++) {
            char t = q[i];
            if (t == '(') {
                stack.offerFirst(')');
            } else if (t == '{') {
                stack.offerFirst('}');
            } else if (t == '[') {
                stack.offerFirst(']');
            } else {
                if (stack.isEmpty() || stack.peekFirst() != t) return false;
                else stack.poll();
            }
        }
        return stack.isEmpty();
    }
}
