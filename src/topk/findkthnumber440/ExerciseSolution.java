package src.topk.findkthnumber440;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/24 09:30:08
 * description:
 */
public class ExerciseSolution {
    // @see https://www.acwing.com/video/1841/
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        while (k > 1) {
            int cnt = f(prefix, n);
            if (k > cnt) {
                prefix++;
                k -= cnt;
            } else {
                prefix *= 10;
                k--;
            }
        }
        return prefix;
    }

    public int f(int prefix, int n) {
        long p = 1;
        String a = String.valueOf(n), b = String.valueOf(prefix);
        int dt = a.length() - b.length();
        int res = 0;
        for (int i = 0; i < dt; i++) {
            res += p;
            p *= 10;
        }
        a = a.substring(0, b.length());
        if (a.compareTo(b) == 0) res += n - prefix * p + 1;
        else if (a.compareTo(b) > 0) res += p;
        return res;
    }
}
