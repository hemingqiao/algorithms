package blogandquestion.algorithms.acwing.hash;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/09 21:46:51
 * description:
 */
public class StringHash {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] fi = in.readLine().split(" ");
        int n = Integer.parseInt(fi[0]), k1 = Integer.parseInt(fi[1]),
                k2 = Integer.parseInt(fi[2]);
        String[] se = in.readLine().split(" "), th = in.readLine().split(" ");
        PriorityQueue<Long> q = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(se[i]), y = Integer.parseInt(th[i]);
            q.offer((long) Math.abs(x - y));
        }
        int total = k1 + k2, j = 0;
        while (total-- > 0) {
            long top = q.poll();
            q.offer(Math.abs(top - 1));
        }
        long ans = 0;
        while (!q.isEmpty()) {
            long tt = q.poll();
            ans += tt * tt;
        }
        out.write(ans + "");
        out.flush();
    }
}
