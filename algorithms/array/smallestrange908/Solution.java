package blogandquestion.algorithms.array.smallestrange908;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/30 22:05:50
 * description:
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 *
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 *
 * 参考：https://github.com/grandyang/leetcode/issues/908
 */
public class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = A[0], min = A[0];
        for (int num : A) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return Math.max(max - min - K * 2, 0);
    }
}
