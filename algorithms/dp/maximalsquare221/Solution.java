package blogandquestion.algorithms.dp.maximalsquare221;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/04 19:43:42
 * description:
 * 参考：https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 */
public class Solution {
    // 从写过的这些题来看，求极值的问题一般要转化为动态规划来求解
    // 就是这个转移方程不好想，想不出来(￣_￣|||)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
