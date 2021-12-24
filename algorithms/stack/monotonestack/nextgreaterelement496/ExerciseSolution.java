package blogandquestion.algorithms.stack.monotonestack.nextgreaterelement496;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/21 21:25:43
 * description:
 */
public class ExerciseSolution {
    public int[] nextGreaterElement(int[] a, int[] b) {
        int n = b.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int x = b[i];
            while (!stack.isEmpty() && stack.peek() <= x) stack.poll();
            if (!stack.isEmpty()) map.put(x, stack.peek());
            else map.put(x, -1);
            stack.offerFirst(x);
        }
        int m = a.length;
        int[] ret = new int[m];
        for (int i = 0; i < m; i++) ret[i] = map.get(a[i]);
        return ret;
    }
}
