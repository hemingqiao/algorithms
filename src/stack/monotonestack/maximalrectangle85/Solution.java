package src.stack.monotonestack.maximalrectangle85;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/12 19:34:20
 * description:
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例 1：
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 * 提示：
 *
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 *
 * 此题是之前那道的 Largest Rectangle in Histogram 的扩展，这道题的二维矩阵每一层向上都可以看做一个直方图，输入矩阵有多少行，就可以形成
 * 多少个直方图，对每个直方图都调用 Largest Rectangle in Histogram 中的方法，就可以得到最大的矩形面积。那么这道题唯一要做的就是将每一层
 * 都当作直方图的底层，并向上构造整个直方图，由于题目限定了输入矩阵的字符只有 '0' 和 '1' 两种，所以处理起来也相对简单。方法是，对于每一个点，
 * 如果是 ‘0’，则赋0，如果是 ‘1’，就赋之前的 height 值加上1。
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int n = matrix[0].length; // 列宽
        int[] height = new int[n];
        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                height[j] = chars[j] == '0' ? 0 : 1 + height[j];
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }

    public int largestRectangleArea(int[] height) {
        int res = 0;
        int[] newHeight = new int[height.length + 2];
        // 最左和最右为0
        for (int i = 1; i < newHeight.length - 1; i++) {
            newHeight[i] = height[i - 1];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int cur = stack.pop();
                int right = i;
                int left = stack.peek();
                res = Math.max(res, (right - left - 1) * newHeight[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
