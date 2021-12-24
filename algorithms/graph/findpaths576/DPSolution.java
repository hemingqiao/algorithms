package blogandquestion.algorithms.graph.findpaths576;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/15 09:37:47
 * description:
 */
public class DPSolution {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        int MOD = (int) (1e9 + 7);
        int[][][] f = new int[m][n][maxMove + 1]; // f[i][j][k]表示从界外移动k步到达坐标(i, j)处的所有方案数
        // 初始化（处理边界情况）
        for (int i = 0; i < m; i++) {
            f[i][0][1]++;
            f[i][n - 1][1]++;
        }
        for (int i = 0; i < n; i++) {
            f[0][i][1]++;
            f[m - 1][i][1]++;
        }
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int u = 0; u < 4; u++) {
                        int a = i + dx[u], b = j + dy[u];
                        if (a >= 0 && a < m && b >= 0 && b < n) {
                            f[i][j][k] = (f[i][j][k] + f[a][b][k - 1]) % MOD;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int k = 1; k <= maxMove; k++) {
            res = (res + f[startRow][startColumn][k]) % MOD;
        }
        return res;
    }
}
