package blogandquestion.algorithms.backtrack.solvenqueens51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/16 21:29:21
 * description:
 * 参考：https://leetcode-cn.com/problems/n-queens/solution/c-hui-su-zui-jian-ji-xie-fa-by-spacex-1/
 */
public class AnotherSolution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }
        int[] col = new int[n]; // 存储已有的列值
        int[] diagonal = new int[2 * n - 1]; // 存储已有的正对角线的值
        int[] antiDiagonal = new int[2 * n - 1]; // 存储已有的反对角线的值
        backtracking(res, chess, 0, n, col, diagonal, antiDiagonal);
        return res;
    }

    private void backtracking(List<List<String>> res, char[][] chess, int row,
                              int n, int[] col, int[] diagonal, int[] antiDiagonal) {
        // 遍历完了所有的行
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : chess) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }

        // 这里的i代表col（列）
        for (int i = 0; i < n; i++) {
            // 这里注意一下，因为行与列的差值可能为负，所以dg下标要加一个n - 1
            // 为什么是加上n - 1呢，因为初始化diagonal数组时其大小是2n - 1，而对于坐标为[n - 1, 0]的正对角线而言，加上n之后，
            // 和为2n - 1，数组会越界，如果初始化diagonal数组时大小定为2n，此处就可以直接加n而不会越界
            if (col[i] == 0 && diagonal[row - i + n - 1] == 0 && antiDiagonal[row + i] == 0) {
                // 将该位置对应的列，正对角线，反对角线的值都置1
                col[i] = diagonal[row - i + n - 1] = antiDiagonal[row + i] = 1;
                chess[row][i] = 'Q';
                backtracking(res, chess, row + 1, n, col, diagonal, antiDiagonal); // 递归
                chess[row][i] = '.'; // 回溯，撤销选择
                // 将该位置对应的列，正对角线，反对角线的值重置为0
                col[i] = diagonal[row - i + n - 1] = antiDiagonal[row + i] = 0;
            }
        }
    }
}
