package src.acwing.contest.ten;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/31 19:31:04
 * description:
 */
public class Two {
    public static int N = 100010;
    public static long[] s = new long[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum = 0;
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            int a = in.nextInt();
            sum += a;
            s[i] = s[i - 1] + a;
        }
        if (sum % 2 == 1) {
            System.out.println(0);
            return;
        }
        long t = sum / 2, res = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == t) ++res;
        }
        System.out.println(res);
    }
}
