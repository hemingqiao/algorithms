package src.numbers.generatematrix59;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/16 13:31:09
 * description:
 */
public class ExerciseSolution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int cnt = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) ret[top][i] = cnt++;
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) ret[i][right] = cnt++;
            if (--right < left) break;
            for (int i = right; i >= left; i--) ret[bottom][i] = cnt++;
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) ret[i][left] = cnt++;
            if (++left > right) break;
        }
        return ret;
    }
}
