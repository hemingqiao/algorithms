package blogandquestion.algorithms.numbers.nthuglynumber264;

import java.util.TreeSet;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/11 10:03:37
 * description:
 */
public class ExerciseSolution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        if (n == 0) return 1;
        while (n > 1) {
            long temp = set.pollFirst();
            set.add(temp * 2);
            set.add(temp * 3);
            set.add(temp * 5);
            --n;
        }
        long res = set.pollFirst();
        return (int) res;
    }

    // 参考：https://github.com/grandyang/leetcode/issues/264
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int m = dp[p1] * 2, p = dp[p2] * 3, q = dp[p3] * 5;
            int temp = Math.min(m, Math.min(p, q));
            dp[i] = temp;
            if (m == temp) ++p1;
            if (p == temp) ++p2;
            if (q == temp) ++p3;
        }
        return dp[n - 1];
    }
}
