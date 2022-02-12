package src.array.surfacearea892;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/28 17:24:09
 * description:
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 *
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 *
 * 参考：https://leetcode-cn.com/problems/surface-area-of-3d-shapes/solution/shi-li-you-tu-you-zhen-xiang-jiang-jie-yi-kan-jiu-/
 */
public class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length; // grid是一个n * n矩阵
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                // 如果高度不为0
                if (height > 0) {
                    // 每个正方体贡献4个侧面积，在加上整个柱体的上下底面面积
                    area = area + (height << 2) + 2;
                    // 只需要减去左侧和上侧与当前柱体相贴的表面积
                    // 如果i大于0，需要减去和[i - 1, j]处相贴的两份表面积（左侧）
                    area = area - (i > 0 ? Math.min(height, grid[i - 1][j]) << 1 : 0);
                    // 如果j大于0，需要减去和[i, j - 1]处相贴的两份表面积（上侧）
                    area = area - (j > 0 ? Math.min(height, grid[i][j - 1]) << 1 : 0);
                }
            }
        }
        return area;
    }
}
