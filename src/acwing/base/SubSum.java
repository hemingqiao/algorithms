package src.acwing.base;

import java.util.*;
import java.io.*;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/05 12:13:49
 * description:
 */
public class SubSum {
}

class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) a[i] = new int[]{in.nextInt(), in.nextInt()};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int count = 0;
        int i = 0;
        while (i < a.length) {
            int l = a[i][0], r = a[i][1];
            while (i < a.length - 1 && a[i + 1][0] <= r) {
                i++;
                r = Math.max(r, a[i][1]);
            }
            count++;
            i++;
        }
        System.out.println(count);
    }
}
