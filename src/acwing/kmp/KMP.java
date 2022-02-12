package src.acwing.kmp;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/28 21:36:08
 * description:
 * @see https://www.acwing.com/problem/content/description/833/
 * @see https://www.acwing.com/solution/content/11332/
 */
public class KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        String p = in.readLine();
        int m = Integer.parseInt(in.readLine());
        String s = in.readLine();
        char[] ss = new char[m + 1], pp = new char[n + 1];
        for (int i = 1; i <= m; i++) ss[i] = s.charAt(i - 1);
        for (int i = 1; i <= n; i++) pp[i] = p.charAt(i - 1);

        int[] ne = new int[n + 1];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && pp[i] != pp[j + 1]) j = ne[j];
            if (pp[i] == pp[j + 1]) j++;
            ne[i] = j;
        }
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && ss[i] != pp[j + 1]) j = ne[j];
            if (ss[i] == pp[j + 1]) j++;
            if (j == n) {
                out.write(i - n + " ");
                j = ne[j];
            }
        }

        out.flush();
        out.close();
        in.close();
    }
}
