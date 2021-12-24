package blogandquestion.algorithms.numbers.ispoweroffour342;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/31 21:05:18
 * description: 二刷
 */
public class ExerciseSolution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public boolean isPowerOfFour1(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & (0b10101010101010101010101010101010)) == n;
    }
}
