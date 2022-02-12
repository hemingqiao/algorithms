package src.leetcodeweeklycontest.c244;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/06 10:16:00
 * description:
 */
public class One {
    public boolean findRotation(int[][] mat, int[][] target) {
        int m = mat.length, n = mat[0].length;
        if (m != n) return false;
        if (Arrays.deepEquals(mat, target)) return true;
        for (int i = 0; i < 3; i++) {
            int[][] temp = rotate(mat);
            if (Arrays.deepEquals(temp, target)) return true;
            mat = temp;
        }
        return false;
    }

    public int[][] rotate(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] ret = new int[n][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                ret[j][m - 1 - i] = a[i][j];
            }
        }
        return ret;
    }

    public boolean isEqual(int[][] a, int[][] b) {
        int m = a.length, n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1}, {1, 0}};
        int[][] b = {{1, 0}, {0, 1}};
        One one = new One();
        boolean res = one.findRotation(a, b);
        System.out.println(res);
        int[][] test = {{0, 1}, {1, 0}};
        boolean isEq = Arrays.deepEquals(a, test);
        System.out.println("\"a test isEqual:\" " + isEq);
    }
}
