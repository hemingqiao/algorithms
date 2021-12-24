package blogandquestion.algorithms.array.sumoddlengthsubarrays1588;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 17:22:13
 * description:
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 *
 * 参考：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/comments/630393
 */
public class Solution {
    // 滑动窗口求解所有奇数长度的子数组和
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int window = 1; window <= arr.length; window += 2) {
            // l和r同时自增保证子序列长度是奇数
            for (int l = 0, r = l + window; r <= arr.length; l++, r++) {
                // 内层循环将子序列的值加到结果上
                for (int i = l; i < r; i++) {
                    res += arr[i];
                }
            }
        }
        return res;
    }
}
