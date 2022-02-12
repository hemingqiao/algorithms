package src.array.maxsumsubmatrix363;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/22 21:40:26
 * description:
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = matrix[i][j];
                if (i > 0) t += sum[i - 1][j];
                if (j > 0) t += sum[i][j - 1];
                if (i > 0 && j > 0) t -= sum[i - 1][j - 1];
                sum[i][j] = t;
                for (int r = 0; r <= i; r++) {
                    for (int c = 0; c <= j; c++) {
                        int d = sum[i][j];
                        if (r > 0) d -= sum[r - 1][j];
                        if (c > 0) d -= sum[i][c - 1];
                        if (r > 0 && c > 0) d += sum[r - 1][c - 1];
                        if (d <= k) res = Math.max(res, d);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] test = new int[][]{{2, 2, -1}};
        int res = s.maxSumSubmatrix(test, 0);
        System.out.println(res);
    }
}
