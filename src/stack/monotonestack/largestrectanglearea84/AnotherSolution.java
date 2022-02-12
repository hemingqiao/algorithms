package src.stack.monotonestack.largestrectanglearea84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 21:05:55
 * description:
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 *
 * 参考：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/
 */
public class AnotherSolution {
    // 利用单调栈向右找到第一个小于当前位置高度的索引，向左找到第一个小于当前位置高度的索引，作为左右边界（都不能取，因为这两个边界上的高度
    // 都小于当前位置高度，所以用来计算的宽度是right - left - 1。
    // 例如：索引为2处的元素是当前位置，左边第一个小于当前高度的索引是1，右边第一个小于当前高度的索引是3，可用于计算的宽度只有当前索引2对应的一个
    // 宽度，左右边界都不能取，即 3 - 1 - 1 = 1
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 在最前方和最后方都补了一个0
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

/*
单调栈分为单调递增栈和单调递减栈
11. 单调递增栈即栈内元素保持单调递增的栈
12. 同理单调递减栈即栈内元素保持单调递减的栈

操作规则（下面都以单调递增栈为例）
21. 如果新的元素比栈顶元素大，就入栈
22. 如果新的元素较小，那就一直把栈内元素弹出来，直到栈顶比新元素小

加入这样一个规则之后，会有什么效果
31. 栈内的元素是递增的
32. 当元素出栈时，说明这个新元素是出栈元素向后找第一个比其小的元素

举个例子，配合下图（见./单调递增栈.png），现在索引在 6 ，栈里是 1 5 6 。
接下来新元素是 2 ，那么 6 需要出栈。
当 6 出栈时，右边 2 代表是 6 右边第一个比 6 小的元素。

当元素出栈后，说明新栈顶元素是出栈元素向前找第一个比其小的元素
当 6 出栈时，5 成为新的栈顶，那么 5 就是 6 左边第一个比 6 小的元素。

参考：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/

 */
