package blogandquestion.algorithms.stack.monotonestack.trap42;

import mycollections.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 21:52:48
 * description:
 * 参考：https://leetcode-cn.com/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
 * 参考：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 * 参考：https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // 维护一个单调递减栈，当栈非空且当前元素大于栈顶元素时，依次弹出栈顶元素
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()]; // 出栈元素对应的高度

                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == h) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int width = i - stack.peek() - 1;
                    int min = Math.min(height[stack.peek()], height[i]);
                    res += (min - h) * width;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
