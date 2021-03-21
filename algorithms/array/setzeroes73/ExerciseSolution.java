package blogandquestion.algorithms.array.setzeroes73;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/21 09:28:16
 * description:
 * 二刷
 * 参考：https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
 */
public class ExerciseSolution {
    // in-place solution
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstColumn = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) matrix[0][j] = matrix[i][0] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (firstRow) {
            for (int i = 0; i < n; i++) matrix[0][i] = 0;
        }
        if (firstColumn) {
            for (int j = 0; j < m; j++) matrix[j][0] = 0;
        }
    }
}
