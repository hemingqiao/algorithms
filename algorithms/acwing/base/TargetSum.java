package blogandquestion.algorithms.acwing.base;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/06 08:53:50
 * description:
 */
public class TargetSum {

}

class Main1 {
    // 题目保证一定有解
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt(), x = in.nextInt();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < m; i++) b[i] = in.nextInt();
        for (int j = 0; j < n; j++) {
            int t = a[j];
            if (t + b[0] > x) break;
            if (t + b[m - 1] < x) continue;
            int idx = find(b, x - t);
            if (t + b[idx] == x) System.out.println(j + " " + idx);
        }
    }

    public static int find(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (a[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
