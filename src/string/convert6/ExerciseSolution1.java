package src.string.convert6;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/24 21:19:00
 * description:
 */
public class ExerciseSolution1 {
    public String convert(String s, int n) {
        if (n < 2) return s;
        int l = s.length();
        StringBuilder[] a = new StringBuilder[l];
        for (int i = 0; i < l; i++) a[i] = new StringBuilder();
        int p = 0, flag = -1;
        for (int i = 0; i < l; i++) {
            a[p].append(s.charAt(i));
            if (p == 0 || p == n - 1) flag = -flag;
            p += flag;
        }
        StringBuilder ret = new StringBuilder();
        for (int j = 0; j < l; j++) ret.append(a[j]);
        return ret.toString();
    }
}
