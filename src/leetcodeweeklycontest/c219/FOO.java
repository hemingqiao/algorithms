package src.leetcodeweeklycontest.c219;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 10:26:37
 * description:
 */
public class FOO {
    public int numberOfMatches(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                ans = ans + n / 2 + 1;
            } else {
                ans = ans + n / 2;
            }
            n = n / 2;
        }
        return ans;
    }

    public int stoneGameVII(int[] stones) {
        String s = "82734";
        return -1;
    }

    public static void main(String[] args) {
        FOO f = new FOO();
        int t = 6;
        int res = f.numberOfMatches(t);
        System.out.println(res);
        String s = "82734";
        String[] c = s.split("");
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
    }
}
