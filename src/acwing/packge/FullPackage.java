package src.acwing.packge;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/10 21:11:51
 * description:
 */
public class FullPackage {

}

/**
 * 完全背包问题 朴素解法
 */
class Main {
    public static int N = 1010;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt();
        int[] v = new int[N], w = new int[N];
        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        int[][] f = new int[N][N];
        // i是物品的个数
        for (int i = 1; i <= n; i++) {
            // j是背包的体积
            for (int j = 0; j <= m; j++) {
                // 完全背包问题，k不能无限大，即不能超过背包的体积
                for (int k = 0; k * v[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}

/**
 * 优化的完全背包，三维降到了二维
 */
class Main2 {
    public static int N = 1010;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt();
        int[] v = new int[N], w = new int[N];
        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        int[][] f = new int[N][N];
        // i是物品的个数
        for (int i = 1; i <= n; i++) {
            // j是背包的体积
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                // 此时背包体积大于等于第i个物品的体积
                if (j >= v[i]) f[i][j] = Math.max(f[i][j], f[i][j - v[i]] + w[i]);
            }
        }
        System.out.println(f[n][m]);
    }
}
