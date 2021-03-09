package blogandquestion.algorithms.stack.removeduplicates1047;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/09 11:14:03
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public String removeDuplicates(String S) {
        Deque<Character> queue = new ArrayDeque<>();
        char[] chars = S.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peekLast() == chars[i]) {
                queue.pollLast();
            } else {
                queue.offer(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : queue) sb.append(c);
        return sb.toString();
    }

    public String removeDuplicates1(String S) {
        if (S.isEmpty()) return S;
        char[] chars = S.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        int p = -1;
        for (int i = 0; i < n; i++) {
            if (p != -1 && chars[i] == sb.charAt(p)) {
                sb.deleteCharAt(p--);
            } else {
                sb.append(chars[i]);
                ++p;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "abbaca";
        String res = es.removeDuplicates1(test);
        System.out.println(res);
    }
}
