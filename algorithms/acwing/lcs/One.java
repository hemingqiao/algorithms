package blogandquestion.algorithms.acwing.lcs;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/16 23:12:22
 * description:
 */
public class One {
    // 题目链接：https://www.acwing.com/problem/content/description/897/
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int[] f = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) f[i] = Math.max(f[i], f[j] + 1);
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(Arrays.toString(f));
        System.out.println(res);
    }
}


