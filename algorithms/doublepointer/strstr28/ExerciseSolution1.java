package blogandquestion.algorithms.doublepointer.strstr28;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/20 13:08:25
 * description:
 */
public class ExerciseSolution1 {
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int n1 = hay.length, n2 = need.length;
        if (n2 == 0) return 0;
        if (n1 == 0 || n2 > n1) return -1;
        for (int i = 0; i < n1 - n2 + 1; i++) {
            if (hay[i] == need[0]) {
                int p = 1;
                while (p < n2 && hay[i + p] == need[p]) {
                    p++;
                }
                if (p == n2) return i;
            }
        }
        return -1;
    }
}
