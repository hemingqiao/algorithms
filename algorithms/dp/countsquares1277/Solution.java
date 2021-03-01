package blogandquestion.algorithms.dp.countsquares1277;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/01 20:32:39
 * description:
 * @see https://leetcode-cn.com/problems/maximal-square/
 * @see blogandquestion.algorithms.dp.maximalsquare221.Solution
 */
public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int cnt = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                cnt += dp[i][j];
            }
        }
        return cnt;
    }
}
