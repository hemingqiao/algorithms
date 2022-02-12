package src.binarysearch.guessnumber374;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/14 09:24:11
 * description:
 */
public class ExerciseSolution {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (guess(mid) <= 0) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // guess是由LeetCode提供的方法
    public int guess(int num) {
        return -1;
    }
}
