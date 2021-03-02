package blogandquestion.algorithms.dp.sumrange304;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/02 08:37:13
 * description:
 * 二刷
 */
public class ExerciseSolution {
    static class NumMatrix {
        private int[][] dp = null;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) return;
            int m = matrix.length, n = matrix[0].length;
            // 构造出了一个长度和宽度均加上1的新矩阵
            dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
                }
            }
        }

        // res = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1]
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1] - dp[row1][col2 + 1];
        }

        public static void main(String[] args) {
            int[][] matrix = new int[5][5];
            matrix[0] = new int[]{3, 0, 1, 4, 2};
            matrix[1] = new int[]{5, 6, 3, 2, 1};
            matrix[2] = new int[]{1, 2, 0, 1, 5};
            matrix[3] = new int[]{4, 1, 0, 1, 7};
            matrix[4] = new int[]{1, 0, 3, 0, 5};

            NumMatrix nm = new NumMatrix(matrix);
            int res = nm.sumRegion(2, 1, 4, 3);
            System.out.println(res);
        }
    }

    // brute force
    static class NumMatrix1 {
        private int[][] matrix;

        public NumMatrix1(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ret = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    ret += matrix[i][j];
                }
            }
            return ret;
        }
    }
}
