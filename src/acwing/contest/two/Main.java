package src.acwing.contest.two;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/12 22:56:51
 * description:
 */
public class Main {
    public static int N = 100010;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt(), k = in.nextInt();
            int[] s = new int[N];
            for (int i = 0; i < n; i++) s[i] = in.nextInt();
            int res = n;
            for (int i = 1; i <= 100; i++) {
                int a = 0;
                for (int j = 0; j < n; j++) {
                    if (s[j] != i) {
                        ++a;
                        j += k - 1;
                    }
                }
                res = Math.min(res, a);
            }
            System.out.println(res);
        }
    }
}
