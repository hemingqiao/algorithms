package blogandquestion.algorithms.acwing.priorityqueue;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/31 20:52:44
 * description:
 */
public class HeapSort {
    public static int N = 100010;
    public static int[] q = new int[N];
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        int n = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
        String[] tt = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) q[i] = Integer.parseInt(tt[i - 1]);
        size = n;
        for (int i = n / 2; i > 0; i--) down(i);
        while (m-- > 0) {
            System.out.print(q[1] + " ");
            q[1] = q[size--];
            down(1);
        }
    }

    public static void down(int u) {
        int t = u;
        if (u * 2 <= size && q[u * 2] < q[t]) t = u * 2;
        if (u * 2 + 1 <= size && q[u * 2 + 1] < q[t]) t = u * 2 + 1;
        if (u != t) {
            swap(q, u, t);
            down(t);
        }
    }

    public static void up(int u) {
        while (u / 2 > 0 && q[u / 2] > q[u]) {
            swap(q, u / 2, u);
            u /= 2;
        }
    }

    public static void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
}
