package src.acwing.acwing237;

import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, Integer> f = new HashMap<>();
    static int N = 100010, n, ia, ib;
    static int[][] a = new int[N][2], b = new int[N][2];

    static int find(int x) {
        if (f.get(x) != x) f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(in.readLine());
            f.clear();
            ia = ib = 0;

            for (int i = 0; i < n; i++) {
                String[] t = in.readLine().split(" ");
                int aa = Integer.parseInt(t[0]), bb = Integer.parseInt(t[1]), e = Integer.parseInt(t[2]);
                if (e == 1) a[ia++] = new int[]{aa, bb};
                else b[ib++] = new int[]{aa, bb};
                f.put(aa, aa);
                f.put(bb, bb);
            }

            for (int i = 0; i < ia; i++) {
                int pa = find(a[i][0]), pb = find(a[i][1]);
                f.put(pa, pb);
            }

            boolean flag = false;
            for (int i = 0; i < ib; i++) {
                int pa = find(b[i][0]), pb = find(b[i][1]);
                if (pa == pb) {
                    flag = true;
                    break;
                }
            }
            if (flag) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}