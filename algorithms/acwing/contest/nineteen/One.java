package blogandquestion.algorithms.acwing.contest.nineteen;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/05 09:46:11
 * description:
 */
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            StringBuilder s = new StringBuilder(in.readLine());
            // 便于处理边界情况
            s.insert(0, '0');
            s.append('0');
            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                char c = s.charAt(i);
                if (c == '1' && s.charAt(i - 1) == '1') {
                    flag = true;
                    break;
                }
                if (c == '0' && s.charAt(i - 1) != '1' && s.charAt(i + 1) != '1') {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                out.write("No\n");
            } else {
                out.write("Yes\n");
            }
            out.flush();
        }
    }
}
