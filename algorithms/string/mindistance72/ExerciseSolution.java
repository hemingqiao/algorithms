package blogandquestion.algorithms.string.mindistance72;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/19 23:08:47
 * description:
 */
public class ExerciseSolution {
    public int minDistance(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] f = new int[n + 1][m + 1];
        // 初始二维状态矩阵的第一行和第一列
        for (int i = 0; i <= n; i++) f[i][0] = i;
        for (int j = 1; j <= m; j++) f[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 删除a串中的最后一个，在a串的最后插入一个，替换掉a串中的最后一个，
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                int t = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + t);
            }
        }
        return f[n][m];
    }
}
