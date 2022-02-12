package src.acwing.binarysearch;

import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/07 10:40:30
 * description:
 */
public class NumberRange {
    public static int N = 100010;
    public static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ");
        int n = Integer.parseInt(ss[0]), q = Integer.parseInt(ss[1]);
        String[] second = in.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(second[i]);
        while (q-- > 0) {
            int t = Integer.parseInt(in.readLine());
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (a[mid] >= t) r = mid;
                else l = mid + 1;
            }
            if (a[l] != t) {
                System.out.println(-1 + " " + -1);
            } else {
                int b = l;
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (a[mid] <= t) l = mid;
                    else r = mid - 1;
                }
                System.out.println(b + " " + l);
            }
        }
    }
}
