package blogandquestion.algorithms.stack.monotonestack.largestrectanglearea84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 21:05:55
 * description:
 */
public class AnotherSolution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        for (int j = 0; j < newHeights.length; j++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[j]) {
                // 对栈中（单调递增栈）柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
                // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
                // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
                int cur = stack.pop();
                int right = j;
                int left = stack.peek();
                res = Math.max(res, (right - left - 1) * newHeights[cur]);
            }
            stack.push(j);
        }
        return res;
    }
}
