package blogandquestion.algorithms.string.multiply43;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/09 20:52:05
 * description:
 */
public class ExerciseSolution1 {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] a = new int[n], b = new int[m], c = new int[n + m];
        for (int i = n - 1, p = 0; i >= 0; i--) a[p++] = num1.charAt(i) - '0';
        for (int i = m - 1, p = 0; i >= 0; i--) b[p++] = num2.charAt(i) - '0';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i + j] += a[i] * b[j];
            }
        }
        for (int i = 0, t = 0; i < n + m; i++) {
            t = c[i] + t;
            c[i] = t % 10;
            t = t / 10;
        }
        StringBuilder res = new StringBuilder();
        int k = n + m - 1;
        while (k > 0 && c[k] == 0) k--;
        for (int i = k; i >= 0; i--) {
            res.append(c[i]);
        }
        return res.toString();
    }
}
