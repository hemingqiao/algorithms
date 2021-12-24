package blogandquestion.algorithms.array.rotate48;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/26 20:48:24
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 先绕负对角线反转数组，在按照列进行反转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j * 2 < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        es.rotate(test);
        System.out.println(Arrays.deepToString(test));
    }
}
