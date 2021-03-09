package blogandquestion.algorithms.doublepointer.strstr28;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/21 13:48:45
 * description:
 */
public class ExerciseSolution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) return 0;
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == m - 1) return i;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        int M = haystack.length(), N = needle.length();
        if (N == 0) return 0;
        for (int i = 0; i < M - N + 1; i++) {
            int j = i, p = 0;
            while (p < N && haystack.charAt(j) == needle.charAt(p)) {
                j++;
                p++;
            }
            if (p == N) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "hello";
        String tar = "el";
        int res = es.strStr(test, tar);
        System.out.println(res);
    }
}
