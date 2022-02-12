package src.leetcodeweeklycontest.c248;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/04 14:00:26
 * description:
 */
public class Two {
    public int eliminateMaximum(int[] d, int[] s) {
        int n = d.length;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = (d[i] + s[i] - 1) / s[i];
        Arrays.sort(t);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i < t[i]) ++res;
            else break;
        }
        return res;
    }
}
