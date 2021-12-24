package blogandquestion.algorithms.acwing.dfs.queen;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/03 11:59:18
 * description:
 */
public class NQueen {
    public static int N = 20;
    public static char[][] b = new char[N][N];
    public static boolean[] col = new boolean[N]; // 用来标记某一列是否放置了皇后
    public static boolean[] dg = new boolean[N], udg = new boolean[N]; // 分别用来标记正对角线和反对角线上是否放置了皇后
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) b[i][j] = '.';
        }
        dfs(0);
    }

    public static void dfs(int p) {
        // 当每一列都成功放置了一个皇后，表明找到了一组可行解
        if (p == n) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s = new StringBuilder();
                for (int j = 0; j < n; j++) s.append(b[i][j]);
                System.out.println(s);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            // dg方程，y = x + b -> b = y - x，防止数组下标越界，在加上n，有 b = y - x + n
            // 同理 udg方程，y = x - b -> b = y + x，在这里，x就是列下标i，y就是行下标p
            // 当前列没有放置皇后，当前正对角线、斜对角线都没有放置皇后
            if (!col[i] && !dg[p - i + n] && !udg[i + p]) {
                b[p][i] = 'Q';
                col[i] = true;
                col[i] = dg[p - i + n] = udg[i + p] = true;
                dfs(p + 1); // 递归进入下一行
                col[i] = dg[p - i + n] = udg[i + p] = false;
                col[i] = false;
                b[p][i] = '.';
            }
        }
    }
}
