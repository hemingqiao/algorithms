package blogandquestion.algorithms.backtrack.solvenqueens51;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/03 12:10:55
 * description:
 *
 * @see https://www.acwing.com/activity/content/problem/content/906/1/
 * @see https://www.acwing.com/solution/content/15884/
 */
public class ExerciseSolution {
    int n;
    boolean[] col, dg, udg; // 分别代表列，正对角线，反对角线上是否放置了皇后
    char[][] b;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new boolean[n];
        dg = new boolean[n * 2];
        udg = new boolean[n * 2];
        b = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) b[i][j] = '.';
        }
        dfs(0, res);
        return res;
    }

    public void dfs(int row, List<List<String>> res) {
        if (row == n) {
            // 这里用String的话执行时间13ms，用StringBuilder的话执行时间2ms
            StringBuilder s = new StringBuilder();
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                s = new StringBuilder();
                for (int j = 0; j < n; j++) s.append(b[i][j]);
                temp.add(s.toString());
            }
            res.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            // dg方程，y = x + b -> b = y - x，防止数组下标越界，在加上n，有 b = y - x + n
            // 同理 udg方程，y = x - b -> b = y + x，在这里，x就是列下标i，y就是行下标row
            // 当前列没有放置皇后，当前正对角线、斜对角线都没有放置皇后
            if (!col[i] && !dg[row - i + n] && !udg[row + i]) {
                b[row][i] = 'Q';
                col[i] = dg[row - i + n] = udg[row + i] = true;
                dfs(row + 1, res);
                col[i] = dg[row - i + n] = udg[row + i] = false;
                b[row][i] = '.';
            }
        }
    }
}
