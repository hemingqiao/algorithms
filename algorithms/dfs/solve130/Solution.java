package blogandquestion.algorithms.dfs.solve130;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/12 22:17:25
 * description:
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例 1：
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *
 *
 * 提示：
 *
 *     m == board.length
 *     n == board[i].length
 *     1 <= m, n <= 200
 *     board[i][j] 为 'X' 或 'O'
 */
public class Solution {
    char[][] b;
    int n, m;
    int[][] d;
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    // flood fill
    public void solve(char[][] board) {
        b = board;
        n = b.length;
        m = b[0].length;
        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (b[i][0] == 'O') dfs(i, 0);
            if (b[i][m - 1] == 'O') dfs(i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (b[0][j] == 'O') dfs(0, j);
            if (b[n - 1][j] == 'O') dfs(n - 1, j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j] == 0) b[i][j] = 'X';
            }
        }
    }

    public void dfs(int i, int j) {
        d[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            int aa = i + dx[k], bb = j + dy[k];
            if (aa >= 0 && aa < n && bb >= 0 && bb < m && b[aa][bb] == 'O' && d[aa][bb] == 0) {
                dfs(aa, bb);
            }
        }
    }
}
