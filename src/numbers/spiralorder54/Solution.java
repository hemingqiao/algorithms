package src.numbers.spiralorder54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/11 14:17:53
 * description: 借鉴了59的解题思路，需要注意的是需要在for循环的内部判断是否已经遍历完整个矩阵，因为矩阵不是n * n，而是一个m * n的。
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 *
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int count = 1, tar = matrix.length * matrix[0].length;
        while (count <= tar) {
            for (int i = left; i <= right; i++) {
                if (count > tar) break;
                res.add(matrix[top][i]);
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if (count > tar) break;
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                if (count > tar) break;
                res.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                if (count > tar) break;
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return res;
    }
}
