package blogandquestion.algorithms.array.gameoflife289;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 15:24:35
 * description:
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbours(copy, i, j, m, n);
                if (copy[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public int countNeighbours(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        int[][] dirs = new int[][]{{-1,-1}, {-1,0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            count += board[x][y];
        }
        return count;
    }
}
