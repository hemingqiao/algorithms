package src.leetcodeweeklycontest.c224;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 10:28:08
 * description:
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 *
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
 *
 * 示例 1：
 *
 * 输入：matrix = [[0,0,1],[1,1,1],[1,0,1]]
 * 输出：4
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 4 。
 * 示例 2：
 *
 * 输入：matrix = [[1,0,1,0,1]]
 * 输出：3
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 3 。
 * 示例 3：
 *
 * 输入：matrix = [[1,1,0],[1,0,1]]
 * 输出：2
 * 解释：由于你只能整列整列重新排布，所以没有比面积为 2 更大的全 1 子矩形。
 * 示例 4：
 *
 * 输入：matrix = [[0,0],[0,0]]
 * 输出：0
 * 解释：由于矩阵中没有 1 ，没有任何全 1 的子矩阵，所以面积为 0 。
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m * n <= 105
 * matrix[i][j] 要么是 0 ，要么是 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements
 *
 * 参考：https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements/solution/java-yu-chu-li-shu-zu-bian-li-mei-xing-p-qpqu/
 * 参考：https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements/solution/zhu-xing-bian-li-yu-bao-cun-lie-zhong-1d-ax0n/
 */
public class Three {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = n - 1; j >= 0; j--) {
                int height = matrix[i][j];
                res = Math.max(res, height * (n - j));
            }
        }
        return res;
    }
}

/*
解题思路：
预处理数组，计算以这个点为结尾，上面有多少个连续的1，就是这一列以这个点为结尾的最大高度
这样就将二维问题转成一维

遍历每一行，对每一行进行排序，记录矩形的最长的高度，每次更新结果
 */
