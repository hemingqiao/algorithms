package blogandquestion.algorithms.array.matrixreshape566;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/17 15:29:07
 * description:
 */
public class AnotherSolution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c > m * n) return nums;
        int[][] ret = new int[r][c];
        for (int j = 0; j < m * n; j++) {
            ret[j / c][j % c] = nums[j / n][j % n];
        }
        return ret;
    }
}
