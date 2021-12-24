package blogandquestion.algorithms.dp.uniquepaths62;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/12 15:38:55
 * description:
 */
public class ExerciseSolution1 {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) f[i][j] = 1;
                else f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
