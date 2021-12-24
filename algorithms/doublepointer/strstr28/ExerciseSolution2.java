package blogandquestion.algorithms.doublepointer.strstr28;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/29 21:04:02
 * description:
 */
public class ExerciseSolution2 {
    // 这题的数据加强了，必须用kmp才能把时间压到个位数
    public int strStr(String s, String p) {
        int n = s.length(), m = p.length();
        if (m == 0) return 0;
        char[] ss = new char[n + 1], pp = new char[m + 1];
        for (int i = 1; i <= n; i++) ss[i] = s.charAt(i - 1);
        for (int j = 1; j <= m; j++) pp[j] = p.charAt(j - 1);
        int[] ne = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && pp[i] != pp[j + 1]) j = ne[j];
            if (pp[i] == pp[j + 1]) j++;
            ne[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j != 0 && ss[i] != pp[j + 1]) j = ne[j];
            if (ss[i] == pp[j + 1]) j++;
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }
}
