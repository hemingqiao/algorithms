package src.string.atoi8;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/24 21:35:00
 * description:
 */
public class ExerciseSolution2 {
    public int myAtoi(String s) {
        int n = s.length(), res = 0;
        int p = 0;
        while (p < n && s.charAt(p) == ' ') p++;
        if (p == n) return 0;
        boolean positive = true;
        if (!Character.isDigit(s.charAt(p))) {
            if (s.charAt(p) == '-') positive = false;
            else if (s.charAt(p) != '+') return 0;
            p++;
        }
        while (p < n && s.charAt(p) >= '0' && s.charAt(p) <= '9') {
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && s.charAt(p) - '0' > 7) {
                if (positive) return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            res = res * 10 + s.charAt(p) - '0';
            p++;
        }
        return positive ? res : -res;
    }

    public static void main(String[] args) {
        ExerciseSolution2 es2 = new ExerciseSolution2();
        String test = "2147483648";
        int res = es2.myAtoi(test);
        System.out.println(res);
    }
}
