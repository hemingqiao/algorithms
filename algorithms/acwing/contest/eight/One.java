package blogandquestion.algorithms.acwing.contest.eight;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/17 22:53:17
 * description:
 */
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] ss = in.readLine().split(" ");
            int n = Integer.parseInt(ss[0]), a = Integer.parseInt(ss[1]), b = Integer.parseInt(ss[2]), c = Integer.parseInt(ss[3]);
            String[] cc = in.readLine().split("");
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (cc[i].equals("0")) {
                    res += Math.min(a, c + b);
                } else {
                    res += Math.min(b, c + a);
                }
            }
            System.out.println(res);
        }
    }
}
