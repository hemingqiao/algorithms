package blogandquestion.algorithms.array.gameoflife289;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 16:51:22
 * description:
 */
public class AnotherSolution {
    // 原地解法，利用状态机
    // 参考：https://github.com/grandyang/leetcode/issues/289
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
                        count++;
                    }
                }
                if (board[i][j] != 0 && (count < 2 || count > 3)) board[i][j] = 2;
                else if (board[i][j] == 0 && count == 3) board[i][j] = 3;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }

    /*
    状态0： 死细胞转为死细胞（之前状态为死细胞，现在的状态为死细胞）

    状态1： 活细胞转为活细胞（之前状态为活细胞，现在的状态为活细胞）

    状态2： 活细胞转为死细胞（之前状态为活细胞，现在的状态为死细胞）

    状态3： 死细胞转为活细胞（之前状态为死细胞，现在的状态为活细胞）

    状态1、2的前一个状态为活细胞，统计活着的细胞数时需要统计
    最后将这四个状态对2取模，就变成了 0 1 数组
     */
}
