package blogandquestion.algorithms.acwing.kmp;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/26 21:54:32
 * description:
 */
public class KMPBrute {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String N = in.readLine();
        int m = Integer.parseInt(in.readLine());
        String M = in.readLine();
        for (int i = 0; i < m - n + 1; i++) {
            boolean flag = true;
            int p = i;
            for (int j = 0; j < n; j++) {
                if (N.charAt(j) != M.charAt(p)) {
                    flag = false;
                    break;
                }
                p++;
            }
            if (flag) System.out.print(i + " ");
        }
    }
}
