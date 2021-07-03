package blogandquestion.algorithms.backtrack.solvenqueens51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/20 08:39:42
 * description:
 */
public class Exercise {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            // 初始化数组，使用字符 . 进行填充
            Arrays.fill(chess[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        backtracking(res, chess, 0);
        return res;
    }

    private void backtracking(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(matrixToList(chess));
            return;
        }

        // 每一行从左到右进行试探，利用递归和回溯从上到下试探
        for (int i = 0; i < chess.length; i++) {
            if (isValidPosition(chess, row, i)) {
                chess[row][i] = 'Q';
                backtracking(res, chess, row + 1); // 寻找下一行可以放置皇后的位置
                chess[row][i] = '.'; // 回溯，撤销选择
            }
        }
    }

    // 判断当前位置是否可以放置皇后
    private boolean isValidPosition(char[][] chess, int row, int col) {
        // 当前位置的上方不能放置皇后
        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // 当前位置的右上方不能放置皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // 当前位置的左上方不能放置皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // 将字符矩阵转为字符串列表
    private List<String> matrixToList(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (char[] chars : chess) {
            path.add(new String(chars));
        }
        return path;
    }
}
