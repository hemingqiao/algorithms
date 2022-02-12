package src.numbers.integerreverse7;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/03 09:37:54
 * description:
 */
public class ExerciseSolution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res != res * 10 / 10) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
