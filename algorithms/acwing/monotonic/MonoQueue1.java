package blogandquestion.algorithms.acwing.monotonic;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/26 10:20:14
 * description:
 */
public class MonoQueue1 {
    public static int N = 1000010;
    public static int[] q = new int[N];
    public static int[] g = new int[N];
    public static int hh = 0, tt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] first = in.readLine().split(" ");
        int n = Integer.parseInt(first[0]), k = Integer.parseInt(first[1]);
        String[] ss = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(ss[i]);
            g[i] = x;
            if (hh <= tt && q[hh] <= i - k) hh++;
            while (hh <= tt && g[q[tt]] >= x) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(g[q[hh]] + " ");
        }
        hh = 0;
        tt = -1;
        System.out.println();
        for (int i = 0; i < n; i++) {
            int x = g[i];
            if (hh <= tt && g[hh] <= i - k) hh++;
            while (hh <= tt && g[q[tt]] <= x) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(g[q[hh]] + " ");
        }
    }
}
