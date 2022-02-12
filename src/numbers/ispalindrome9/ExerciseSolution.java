package src.numbers.ispalindrome9;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/25 21:34:43
 * description:
 */
public class ExerciseSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x > 0 && x % 10 == 0) return false;
        int a = 0;
        while (x > a) {
            a = a * 10 + x % 10;
            x /= 10;
        }
        return x == a || (x == a / 10);
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        boolean res = es.isPalindrome(0);
        System.out.println(res);
    }
}
