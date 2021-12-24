package blogandquestion.algorithms.stack.monotonestack.nextgreaterelements503;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/21 21:26:25
 * description:
 */
public class ExerciseSolution1 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ret = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            int x = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= x) stack.poll();
            if (i < n) {
                if (!stack.isEmpty()) ret[i] = stack.peek();
                else ret[i] = -1;
            }
            stack.offerFirst(x);
        }
        return ret;
    }
}
