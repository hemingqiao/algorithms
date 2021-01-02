package blogandquestion.algorithms.array.rotatematrixlcci;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/02 22:08:58
 * description:
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 *
 * 注意，本题和48题相同
 *
 * 参考：https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/javajian-dan-yi-dong-yong-shi-ji-bai-100-wiy1/
 */
public class Solution {
    // 按照题意，旋转之后第一行变为了最后一列，第二行变为倒数第二列……
    // 而矩阵转置是第一行变为第一列，第二行变为第二列……
    // 因此首先进行转置，然后将第一列变为最后一列，第二列变为倒数第二列……
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp = 0;
        // 1、转置矩阵
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2、将转置后的矩阵的第一列变为最后一列，第二列变为倒数第二列...
        for (int i = 0; i < len; i++) {
            for (int k = 0; k < len / 2; k++) {
                temp = matrix[i][k];
                matrix[i][k] = matrix[i][len - 1 - k];
                matrix[i][len - 1 - k] = temp;
            }
        }
    }
}
