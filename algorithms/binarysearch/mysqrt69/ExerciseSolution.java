package blogandquestion.algorithms.binarysearch.mysqrt69;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 21:26:10
 * description:
 */
public class ExerciseSolution {
    // 写的不好
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right) >>> 1;
            long t = (long) mid * mid;
            if (t > x) {
                right = mid;
            } else if (t < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int t = 2147395599;
        int res = new ExerciseSolution().mySqrt(t);
        System.out.println(res);
    }

    public int mySqrt1(int x) {
        int ans = 0;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((long)mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
