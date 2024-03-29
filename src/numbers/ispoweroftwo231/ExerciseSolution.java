package src.numbers.ispoweroftwo231;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/30 08:07:57
 * description:
 */
public class ExerciseSolution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n %= 2;
        }
        return n == 1;
    }
}
