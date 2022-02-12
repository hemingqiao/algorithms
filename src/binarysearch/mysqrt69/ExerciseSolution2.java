package src.binarysearch.mysqrt69;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/29 10:27:24
 * description:
 */
public class ExerciseSolution2 {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < x) {
            int mid = (l + r + 1) >>> 1;
            // check函数，为防止mid乘积过大导致溢出，写成了 mid * mid <= x，则答案一定出现在[mid, r]区间内，mid可能是答案
            if (mid <= x / mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
