package src.binarysearch.searchmatrix74;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/22 13:34:51
 * description:
 */
public class ExerciseSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 其实这题也是一种二分查找
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
