package blogandquestion.algorithms.array.largestoverlap835;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/04 19:17:59
 * description:
 * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
 *
 * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
 *
 * （请注意，转换不包括向任何方向旋转。）
 *
 * 最大可能的重叠是什么？
 *
 * 示例 1:
 *
 * 输入：A = [[1,1,0],
 *           [0,1,0],
 *           [0,1,0]]
 *      B = [[0,0,0],
 *           [0,1,1],
 *           [0,0,1]]
 * 输出：3
 * 解释: 将 A 向右移动一个单位，然后向下移动一个单位。
 * 注意: 
 *
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/image-overlap
 *
 */
public class Solution {
    /*
    // 此解法不能AC
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0, n = img1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, Math.max(count(img1, img2, i, j), count(img2, img1, i, j)));
            }
        }
        return res;
    }

    private int count(int[][] img1, int[][] img2, int rowOffset, int colOffset) {
        int n = img1.length;
        int cnt = 0;
        for (int i = rowOffset; i < n; i++) {
            for (int j = colOffset; j < n; j++) {
                cnt += img1[i][j] * img2[i - rowOffset][j - colOffset];
            }
        }
        return cnt;
    }
    */
}

class AnotherSolution {
    // 参考：https://leetcode-cn.com/problems/image-overlap/comments/199746
    public int largestOverlap(int[][] A, int[][] B) {
        int res = 0;
        final int N = A.length;
        int[][] count = new int[2 * N + 1][2 * N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) {
                    for (int m = 0; m < N; m++) {
                        for (int n = 0; n < N; n++) {
                            if (B[m][n] == 1) {
                                count[m - i + N][n - j + N]++;
                            }
                        }
                    }
                }
            }
        }
        for (int[] ints : count) {
            for (int anInt : ints) {
                res = Math.max(res, anInt);
            }
        }
        return res;
    }
}
