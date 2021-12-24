package blogandquestion.algorithms.binarysearch.searchmatrix74;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/16 22:07:39
 * description:
 */
public class ExerciseSolution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (matrix[mid / m][mid % m] >= target) r = mid;
            else l = mid + 1;
        }
        return matrix[l / m][l % m] == target;
    }
}
