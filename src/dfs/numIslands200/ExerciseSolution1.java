package src.dfs.numIslands200;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/11 09:23:14
 * description:
 */
public class ExerciseSolution1 {
    public char[][] g;
    public int n, m;
    public int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    // flood fill算法
    public int numIslands(char[][] grid) {
        g = grid;
        n = g.length;
        m = g[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    public void dfs(int x, int y) {
        g[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && g[a][b] == '1') dfs(a, b);
        }
    }
}
