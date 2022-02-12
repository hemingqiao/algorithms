package src.dp.sumrange304;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/02 12:53:07
 * description:
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 *
 * 参考：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-57/
 */
public class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        int row = matrix.length, col = matrix[0].length;
        dp = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 对于一个四方格子，格子右下方的值[i + 1][j + 1]等于[i + 1][j]（左侧）的值加上[i][j + 1]（上方）值与当前元素的值之和
                // 但是[i][j]处加了两次，需要减去一次，就有了下面的状态转移方程
                dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1] - dp[row1][col2 + 1];
    }
}
