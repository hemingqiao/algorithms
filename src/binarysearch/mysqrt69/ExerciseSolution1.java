package src.binarysearch.mysqrt69;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/01 19:33:18
 * description:
 * 这题看似简单，真容易出错
 */
public class ExerciseSolution1 {
    // brute force
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x <= 3) return 1;
        if (x == 4) return 2;
        long ret = 2;
        for (long j = 2; j * j <= x; j++) {
            ret = Math.max(ret, j);
        }
        return (int) ret;
    }

    // 可以用二分搜索
    public int mySqrt1(int x) {
        int ret = 0;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((long) mid * mid <= x) {
                ret = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ExerciseSolution1 es1 = new ExerciseSolution1();
        int x = 2147395600;
        int res = es1.mySqrt(x);
        System.out.println(res);
    }
}
