package src.backtrack.solvesudoku37;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/07 12:28:06
 * description:
 */
public class ExerciseSolution {
    public boolean[][] row = new boolean[9][9]; // 记录每一行每个数是否被使用过
    public boolean[][] col = new boolean[9][9]; // 记录每一列每个数是否被使用过
    public boolean[][][] cell = new boolean[3][3][9]; // 记录每个小方阵内每个数是否被使用过

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int sx, int sy) {
        if (sy == 9) {
            sy = 0;
            sx++;
        }
        if (sx == 9) return true;
        if (board[sx][sy] != '.') return dfs(board, sx, sy + 1);
        for (int i = 0; i < 9; i++) {
            if (!row[sx][i] && !col[sy][i] && !cell[sx / 3][sy / 3][i]) {
                board[sx][sy] = (char) (i + '1');
                row[sx][i] = col[sy][i] = cell[sx / 3][sy / 3][i] = true;
                if (dfs(board, sx, sy + 1)) return true;
                row[sx][i] = col[sy][i] = cell[sx / 3][sy / 3][i] = false;
                board[sx][sy] = '.';
            }
        }
        return false;
    }
}
