package blogandquestion.algorithms.backtrack.solvesudoku37;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/31 20:20:21
 * description:
 *
 * 参考：https://leetcode-cn.com/problems/sudoku-solver/solution/hui-su-jie-jue-by-sdwwld/
 */
public class Solution {
    public boolean solveSudoku(char[][] board) {
        return backtracking(board, 0, 0);
    }

    private boolean backtracking(char[][] board, int row, int col) {
        // 如果row等于了board的length，表明已经遍历完了所有的行，可以返回true了
        // 需要注意的就是行是从索引0开始的
        if (row == board.length) return true;
        // 如果col等于了board的length，表明本行已经遍历完了，可以遍历下一行了（递归调用）
        if (col == board.length) return backtracking(board, row + 1, 0);
        // 如果当前位置已经填入了数字，跳过当前位置，直接到这一列的下一列
        if (board[row][col] != '.') return backtracking(board, row, col + 1);
        // 如果上面条件都不满足，从1到9依次尝试，直到找到合适的
        for (char i = '1'; i <= '9'; i++) {
            // 判断当前位置能够放下i，如果不能，尝试下一个
            if (!isValid(board, row, col, i)) {
                continue;
            }
            // 如果能放数字i，就把i放进去
            board[row][col] = i;
            if (backtracking(board, row, col + 1)) { // 对下一列的位置调用递归，如果成功就直接返回，不需要再尝试了
                return true;
            }
            board[row][col] = '.'; // 否则撤销选择，进行回溯
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) { // 判断当前行有没有和字符c重复的
                return false;
            }
            if (board[i][col] == c) { // 判断当前列有没有和字符c重复的
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) { // 判断当前单元格内有没有和字符c重复的
                return false;
            }
        }
        return true;
    }
}
