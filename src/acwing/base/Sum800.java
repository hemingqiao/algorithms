package src.acwing.base;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/29 22:47:02
 * description:
 */
public class Sum800 {
    public static int N = 100010;
    public static int[] p = new int[N], q = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] first = in.readLine().split(" ");
        int n = Integer.parseInt(first[0]), m = Integer.parseInt(first[1]), x = Integer.parseInt(first[2]);
        String[] second = in.readLine().split(" "), third = in.readLine().split(" ");
        for (int i = 0; i < n; i++) p[i] = Integer.parseInt(second[i]);
        for (int i = 0; i < m; i++) q[i] = Integer.parseInt(third[i]);
        for (int i = 0, j = m - 1; i < n; i++) {
            while (j >= 0 && p[i] + q[j] > x) j--;
            if (p[i] + q[j] == x) {
                System.out.println(i + " " + j);
//                out.write(i + " " + j); // 不写入
                return;
            }
        }
        out.flush();
        out.close();
        in.close();
    }
}
