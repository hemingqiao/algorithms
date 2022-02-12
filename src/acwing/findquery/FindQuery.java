package src.acwing.findquery;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/31 12:26:47
 * description:
 */
public class FindQuery {
    public static int N = 100010;
    public static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        int n = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
        for (int i = 0; i < n; i++) p[i] = i;
        while (m-- > 0) {
            String[] tt = in.readLine().split(" ");
            int a = Integer.parseInt(tt[1]), b = Integer.parseInt(tt[2]);
            if ("M".equals(tt[0])) p[find(a)] = find(b);
            else {
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    public static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
