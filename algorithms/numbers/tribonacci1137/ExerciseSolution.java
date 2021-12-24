package blogandquestion.algorithms.numbers.tribonacci1137;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/08 09:49:03
 * description:
 */
public class ExerciseSolution {
    public int tribonacci(int n) {
        return tribonacci(n, 0, 1, 1);
    }

    public int tribonacci(int n, int a, int b, int c) {
        switch(n) {
            case 0: return a;
            case 1: return b;
            case 2: return c;
            default: return tribonacci(n - 1, b, c, a + b + c);
        }
    }
}
