package blogandquestion.algorithms.greedy.matrixscore861;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/07 09:02:13
 * description:
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 *
 * 参考：https://github.com/grandyang/leetcode/issues/861
 */
public class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        // 想要得到最大的数，首先确保每一行的第一位都为1，这样至少可以得到 m * (1 << (n - 1))
        int res = m * (1 << (n - 1));
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            // 统计每一列中与行开头处元素相同的个数，如果小于行的一半，反转此列，使得cnt大于行的一半
            for (int j = 0; j < m; j++) {
                if (A[j][i] == A[j][0]) cnt++;
            }
            if (cnt < m - cnt) {
                cnt = m - cnt;
            }
            // 加上此列的1代表的值
            res += cnt * (1 << (n - 1 - i));
        }
        return res;
    }
}
