package src.stack.monotonestack.largestrectanglearea84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/26 13:06:37
 * description:
 */
public class ExerciseSolution1 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] h = new int[n + 2];
        // 在新数组的最前和最后分别添加了一个0，以防止heights数组中元素都相同时强制栈中元素出栈
        // for (int i = 0; i < n; i++) h[i + 1] = heights[i]; // same as
        System.arraycopy(heights, 0, h, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < n + 2; i++) {
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                int cur = stack.pop();
                int left = stack.peek(); // 当前柱体左侧第一个小于当前柱体的元素索引
                int right = i; // 当前柱体右侧第一个小于当前柱体的元素索引
                res = Math.max(res, (right - left - 1) * h[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ExerciseSolution1 es = new ExerciseSolution1();
        int[] test = new int[]{1, 1};
        int res = es.largestRectangleArea(test);
        System.out.println(res);
    }
}
