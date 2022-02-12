package src.stack.monotonestack.dailytemperatures739;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/20 23:37:52
 * description:
 */
public class ExerciseSolution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ret = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int x = t[i];
            while (!q.isEmpty() && t[q.peek()] <= x) q.poll();
            if (!q.isEmpty()) ret[i] = q.peek() - i;
            q.offerFirst(i);
        }
        return ret;
    }
}
