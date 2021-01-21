package blogandquestion.algorithms.binarysearch.divide29;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/21 14:27:23
 * description:
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long m = Math.abs((long) dividend), n = Math.abs((long)divisor);
        int sign = -1;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            sign = 1;
        }
        if (n == 1) return (int) (sign == 1 ? m : -m);
        long res = 0;
        while (m >= n) {
            long temp = n, p = 1;
            while (m >= (temp << 1)) {
                temp <<= 1;
                p <<= 1;
            }
            res += p;
            m -= temp;
        }
        return (int) (sign == 1 ? res : -res);
    }

    public static void main(String[] args) {
        int test = -2147483648;
        int divisor = 2;
        Solution s = new Solution();
        int res = s.divide(test, divisor);
        System.out.println(res);
    }
}
