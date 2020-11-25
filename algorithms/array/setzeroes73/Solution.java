package blogandquestion.algorithms.array.setzeroes73;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 12:51:46
 * description:
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 *
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        Map<Integer, int[]> map = new HashMap<>();
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    map.put(count++, new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < map.size(); i++) {
            int[] temp = map.get(i);
            setZero(matrix, temp[0], temp[1]);
        }
    }

    public void setZero(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[x][j] = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] test = new int[3][3];
        test[0] = new int[]{1, 1, 1};
        test[1] = new int[]{1, 0, 1};
        test[2] = new int[]{1, 1, 1};
        s.setZeroes(test);
        for (int[] ints : test) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
