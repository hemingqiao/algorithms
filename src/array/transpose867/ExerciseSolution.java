package src.array.transpose867;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/25 19:06:36
 * description:
 */
public class ExerciseSolution {
    // 参考：https://github.com/grandyang/leetcode/issues/867
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = matrix[j][i];
            }
        }
        return ret;
    }
}
