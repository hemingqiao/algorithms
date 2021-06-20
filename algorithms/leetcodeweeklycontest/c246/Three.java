package blogandquestion.algorithms.leetcodeweeklycontest.c246;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/20 19:57:07
 * description:
 */
public class Three {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public int countSubIslands(int[][] g1, int[][] g2) {
        int n = g1.length, m = g1[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g2[i][j] == 1) {
                    if (dfs(g1, g2, n, m, i, j)) ++res;
                }
            }
        }
        return res;
    }

    // flood fill算法
    // see: https://www.acwing.com/activity/content/problem/content/907/1/
    public boolean dfs(int[][] g1, int[][] g2, int n, int m, int x, int y) {
        g2[x][y] = 0; // 表示遍历过该位置了，将其清空
        if (g1[x][y] == 0) return false;
        boolean res = true;
        // 遍历上下左右四个方向，判断矩阵2中的点对应到矩阵1中是否为1
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && g2[a][b] == 1) {
                if (!dfs(g1, g2, n, m, a, b)) res = false;
            }
        }
        return res;
    }
}
