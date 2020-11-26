package blogandquestion.algorithms.array.flipandinvertimage832;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 12:42:36
 * description:
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 *
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 *
 */
public class Solution {
    // 二分加上位运算
    // 没参考题解，击败了100%🎉
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            int left = 0, right = col - 1;
            // 因为是二进制矩阵，所以元素值只有0和1
            // 而由于需要反转（1 -> 0, 0 -> 1），可以利用位运算，1 ^ 1 == 0, 0 ^ 1 == 1
            while (left < right) {
                /*if (A[i][left] == 1) {
                    A[i][left] = 0;
                } else {
                    A[i][left] = 1;
                }*/
                A[i][left] = A[i][left] ^ 1;

                /*if (A[i][right] == 1) {
                    A[i][right] = 0;
                } else {
                    A[i][right] = 1;
                }*/
                A[i][right] = A[i][right] ^ 1;
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] = A[i][left] ^ 1;
            }
        }
        return A;
    }
}
