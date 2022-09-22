package src.backtrack.isvalidsudoku36;

public class ExerciseSolution1 {
    boolean[][] row = new boolean[9][9], col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int t = board[i][j] - '1';
                if (row[i][t] || col[j][t] || cell[i / 3][j / 3][t])
                    return false;
                row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
            }
        return true;
    }
}
