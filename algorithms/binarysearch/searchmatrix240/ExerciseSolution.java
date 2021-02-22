package blogandquestion.algorithms.binarysearch.searchmatrix240;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/22 13:13:41
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 边界条件需要注意
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0]) return false;
        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) return true;
                }
            }
        }
        return false;
    }


    // 下面是一种利用二分搜索的解法
    // 参考：https://github.com/grandyang/leetcode/issues/240#issuecomment-629755823
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        return binarySearch(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    public boolean binarySearch(int[][] matrix, int top, int bottom, int left, int right, int target) {
        if (top > bottom || left > right) return false;
        int x = (top + bottom) >>> 1;
        int y = (left + right) >>> 1;
        int center = matrix[x][y];
        if (center == target) {
            return true;
        } else if (center < target) {
            // 从当前位置向下或者向右搜索
            return binarySearch(matrix, x + 1, bottom, left, right, target) ||
                    binarySearch(matrix, top, bottom, y + 1, right, target);
        } else {
            // 从当前位置向上或者向左搜索
            return binarySearch(matrix, top, x - 1, left, right, target) ||
                    binarySearch(matrix, top, bottom, left, y - 1, target);
        }
    }
}
