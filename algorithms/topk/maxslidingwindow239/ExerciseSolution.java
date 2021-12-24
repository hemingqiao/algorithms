package blogandquestion.algorithms.topk.maxslidingwindow239;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/17 09:31:54
 * description:
 * @see https://www.acwing.com/video/1623/
 */
public class ExerciseSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, p = 0;
        int[] ret = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 如果队头元素已经移出窗口，将其从队列（头部）弹出
            if (!q.isEmpty() && i - k + 1 > q.peek()) q.poll();
            // 只要新的元素的值大于等于左边（队列中）的值，将左边较小的值从队列中弹出（从队列尾部弹出）
            // 这样队列中的元素就一定是单调递减的了
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
            q.offer(i);
            // 如果窗口已经形成（窗口内元素大于等于k）
            if (i >= k - 1) ret[p++] = nums[q.peek()];
        }
        return ret;
    }
}
