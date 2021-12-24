package blogandquestion.algorithms.string.compareversion165;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/27 23:42:54
 * description:
 */
public class ExerciseSolution {
    public int compareVersion(String a, String b) {
        String[] v1 = a.split("\\."), v2 = b.split("\\.");
        int max = Math.max(v1.length, v2.length);
        for (int i = 0; i < max; i++) {
            int m = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int n = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (m > n) return 1;
            else if (m < n) return -1;
        }
        return 0;
    }

    public int compareVersion1(String v1, String v2) {
        int m = v1.length(), n = v2.length();
        int i = 0, j = 0;
        while (i < m || j < n) {
            int a = 0, b = 0;
            while (i < m && v1.charAt(i) != '.') a = a * 10 + (v1.charAt(i++) - '0');
            while (j < n && v2.charAt(j) != '.') b = b * 10 + (v2.charAt(j++) - '0');
            if (a > b) return 1;
            else if (a < b) return -1;
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int res = es.compareVersion1("1.01", "1.001");
        System.out.println(res);
    }
}
