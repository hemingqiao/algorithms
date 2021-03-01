package blogandquestion.algorithms.dp.maximalsquare221;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/01 20:21:12
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int maximalSquare(char[][] matrix) {
        // 状态转移方程的推到可以参见位于这个包内的图片(maximal-square.png)
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') dp[i][j] = 1;
                } else if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    // other solution
    // 参考：https://leetcode-cn.com/problems/maximal-square/solution/yuan-yi-wei-shi-jian-hui-chao-jie-guo-zhi-yong-lia/
    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int sideLen = search(matrix, i, j);
                    if (sideLen > res) res = sideLen;
                }
            }
        }
        return res * res;
    }

    public int search(char[][] matrix, int row, int column) {
        int m = matrix.length, n = matrix[0].length;
        int cnt = 1;
        while (row + cnt < m && column + cnt < n) {
            for (int i = 0; i <= cnt; i++) {
                if (matrix[row + cnt][column + i] == '0') return cnt;
                if (matrix[row + i][column + cnt] == '0') return cnt;
            }
            ++cnt;
        }
        return cnt;
    }
}
