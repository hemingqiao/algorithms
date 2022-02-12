package src;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/08 08:34:15
 * description:
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        for (int v : dp) {
            res += v;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 6, 7};
        int result = new ArithmeticSlices().numberOfArithmeticSlices(test);
        System.out.println(result);
    }
}
