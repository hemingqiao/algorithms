package blogandquestion.algorithms.numbers.mypow50;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 22:13:22
 * description:
 */
public class ExerciseSolution {
    public double myPow(double x, int n) {
        return myPowAux(x, n);
    }

    public double myPowAux(double x, long n) {
        if (n == 0) return 1; // 递归出口
        if (n < 0) return 1 / myPowAux(x, -n);
        // n为奇数
        if ((n & 1) == 1) {
            return x * myPowAux(x, n - 1);
        }
        double t = myPowAux(x, n >> 1);
        return t * t;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        double res = es.myPow(2, 4);
        System.out.println(res);
    }
}
