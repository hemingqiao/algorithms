package src.stack.monotonestack.largestrectanglearea84;

import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 19:32:21
 * description:
 */
public class ExerciseSolution {
    // 超时
    public int largestRectangleArea(int[] heights) {
        int maxArea = heights[0];
        int n = heights.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            min = heights[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * min);
            }
        }
        return maxArea;
    }

    // 超时，但比上面的解法稍微好一些
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int cur = heights[i];
            int width = 1;
            int j = i;
            while (++j < n && heights[j] >= cur) width++;
            j = i;
            while (--j >= 0 && heights[j] >= cur) width++;
            maxArea = Math.max(maxArea, cur * width);
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] newHeights = new int[n + 2]; // 在原数组的最前面和最后面分别添加了一个0，防止出现数组中所有的柱体高度都一样
        for (int i = 1; i < n + 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        for (int j = 0; j < n + 2; j++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[j]) {
                int cur = stack.pop();
                int left = stack.peek(); // 当前柱体左边第一个小于当前柱体高度的柱体索引
                int right = j; // 当前柱体右侧第一个小于当前柱体高度的柱体索引
                maxArea = Math.max(maxArea, (right - left - 1) * newHeights[cur]);
            }
            stack.push(j);
        }
        return maxArea;
    }
}
