package blogandquestion.algorithms.string.atoi8;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/10 21:30:27
 * description:
 * 还得多写几遍
 */
public class ExerciseSolution1 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int p = 0;
        // 排除前导的空格
        while (p < n && s.charAt(p) == ' ') {
            p++;
        }
        if (p == n) return 0;
        boolean isNegative = false;
        if (!Character.isDigit(s.charAt(p))) {
            if (s.charAt(p) != '+' && s.charAt(p) != '-') {
                return 0;
            }
            // 不要忘记p++
            isNegative = s.charAt(p++) == '-';
        }
        int ret = 0;
        while (p < n && Character.isDigit(s.charAt(p))) {
            if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && (s.charAt(p) - '0' > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // 同样，这里也不要忘记p++
            ret = ret * 10 + (s.charAt(p++) - '0');
        }
        return isNegative ? -ret : ret;
    }
}
