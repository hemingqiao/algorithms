package blogandquestion.algorithms.backtrack.isvalidsudoku36;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/07 11:21:37
 * description:
 */
public class ExerciseSolution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] st = new boolean[9];
        // 判断行
        for (int i = 0; i < 9; i++) {
            Arrays.fill(st, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    if (st[t]) return false;
                    st[t] = true;
                }
            }
        }
        // 判断列
        for (int i = 0; i < 9; i++) {
            Arrays.fill(st, false);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int t = board[j][i] - '1';
                    if (st[t]) return false;
                    st[t] = true;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(st, false);
                for (int x = 0; x < 3; x++)
                for (int y = 0; y < 3; y++)
                    if (board[i + x][j + y] != '.') {
                        int t = board[i + x][j + y] - '1';
                        if (st[t]) return false;
                        st[t] = true;
                    }
            }
        }
        return true;
    }
}
