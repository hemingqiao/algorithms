package blogandquestion.algorithms.array.flipandinvertimage832;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/24 09:05:40
 * description:
 */
public class ExerciseSolution {
    // 由于是需要反转一个二进制矩阵，可以利用异或：1 ^ 1 == 0, 0 ^ 1 == 1;
    public int[][] flipAndInveriImage(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;

                A[i][left] ^= 1;
                A[i][right] ^= 1;
                left++;
                right--;
            }
            if (left == right) A[i][left] ^= 1;
        }
        return A;
    }
}
