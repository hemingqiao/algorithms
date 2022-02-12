package src.acwing.packge;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/11 22:33:50
 * description: 多重背包问题
 */
public class MultiplePack {
    public static int N = 110;

    // 三重循环，朴素解法
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt(); // n是物品的种类个数，m是背包的容积
        int[] v = new int[N], w = new int[N], s = new int[N];
        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }
        int[][] f = new int[N][N];
        // i表示哪种物品
        for (int i = 1; i <= n; i++) {
            // j表示背包容积
            for (int j = 0; j <= m; j++) {
                // k表示选择多少个第i类的物品
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}

class MultiplePackII {
    public static int N = 25000, M = 2010;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt();
        int[] v = new int[N], w = new int[N];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt(), s = in.nextInt();
            int k = 1;
            while (k <= s) {
                cnt++;
                v[cnt] = a * k; // 第i类物品新的容积
                w[cnt] = b * k; // 第i类物品新的价值
                s -= k;
                k *= 2;
            }
            if (s > 0) {
                cnt++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
        }
        n = cnt; // 二进制优化后共有cnt种物品
        int[] f = new int[N];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
