package src.acwing.findquery;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/31 12:54:36
 * description:
 */
public class PointNum {
    public static int N = 100010;
    public static int[] p = new int[N], size = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        int n = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
        for (int i = 0; i < n; i++) {
            p[i] = i;
            size[i] = 1;
        }
        while (m-- > 0) {
            String[] tt = in.readLine().split(" ");
            int a = 0, b = 0;
            if ("C".equals(tt[0])) {
                a = Integer.parseInt(tt[1]);
                b = Integer.parseInt(tt[2]);
                int n1 = find(a), n2 = find(b);
                if (n1 == n2) continue; // 如果两个点已经位于同一个集合中了，不进行任何操作
                p[n1] = n2;
                size[n2] += size[n1];
            } else if ("Q1".equals(tt[0])) {
                a = Integer.parseInt(tt[1]);
                b = Integer.parseInt(tt[2]);
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            } else {
                a = Integer.parseInt(tt[1]);
                System.out.println(size[find(a)]);
            }
        }
    }

    public static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
