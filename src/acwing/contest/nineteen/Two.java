package src.acwing.contest.nineteen;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/05 11:26:35
 * description:
 */
public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] f = in.readLine().split(" ");
        int n = Integer.parseInt(f[0]), w = Integer.parseInt(f[1]);
        int s = 0, l = 0, r = w;
        String[] se = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            s += Integer.parseInt(se[i]);
            l = Math.max(l, -s);
            r = Math.min(r, w - s);
        }
        int ans = Math.max(0, r - l + 1);
        out.write(ans + "");
        out.flush();
    }
}
