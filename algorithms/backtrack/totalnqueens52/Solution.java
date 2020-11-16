package blogandquestion.algorithms.backtrack.totalnqueens52;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/16 22:08:00
 * description: 只需要将51的解法稍微更改一下，将记录解改为记录解的个数。这题还有优化的空间，从题解看到N皇后问题的解是对称的，所以遍历到
 * 一半就可以，以后再学习吧。🤪
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *  
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 *
 */
public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }
        int[] col = new int[n]; // 存储已有的列值
        int[] diagonal = new int[2 * n - 1]; // 存储已有的正对角线的值
        int[] antiDiagonal = new int[2 * n - 1]; // 存储已有的反对角线的值
        backtracking(chess, 0, n, col, diagonal, antiDiagonal);
        return count;
    }

    private void backtracking(char[][] chess, int row, int n, int[] col, int[] diagonal, int[] antiDiagonal) {
        // 遍历完了所有的行
        if (row == n) {
            count++; // 计数器加1，记录当前的一个解
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
                backtracking(chess, row + 1, n, col, diagonal, antiDiagonal); // 递归
                chess[row][i] = '.'; // 回溯，撤销选择
                // 将该位置对应的列，正对角线，反对角线的值重置为0
                col[i] = diagonal[row - i + n - 1] = antiDiagonal[row + i] = 0;
            }
        }
    }
}
