package blogandquestion.algorithms.binarysearch.searchmatrix240;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/30 13:18:09
 * description:
 * 三刷
 * 第一个例子：
 * [1 , 4, 7, 11, 15],
 * [2 , 5, 8, 12, 19],
 * [3 , 6, 9, 16, 22],
 * [10, 13,14,17, 24],
 * [18, 21,23,26, 30]
 */
public class ExerciseSolution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            int temp = matrix[i][j];
            if (temp == target) {
                return true;
            } else if (target > temp) {
                // 如果目标值大于temp，则target必然位于当前行的下面，因为每列的元素从上到下升序排列
                // 但是不能是j--，因为target > temp一定可以确定位于当前行的下面，却不能确定目标位于当前列的左边或者右边
                // 如第一个例子，如果目标值是16，大于15，位于当前列的左边，如果目标值是19，则是位于当前列
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
