package blogandquestion.algorithms.stack.monotonestack.largestrectanglearea84;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 20:56:13
 * description: 暴力解法，从当前位置开始找到所有高度大于等于当前位置的矩形，求解面积
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int width = 1;
            int height = heights[i];
            int j = i;
            while (--j >= 0 && heights[j] >= height) {
                width++;
            }
            j = i;
            while (++j < len && heights[j] >= height) {
                width++;
            }
            area = Math.max(area, width * height);
        }
        return area;
    }
}
