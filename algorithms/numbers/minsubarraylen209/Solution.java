package blogandquestion.algorithms.numbers.minsubarraylen209;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/09 20:16:52
 * description:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 *
 * 解题思路：使用滑动窗口。执行时间从153ms降到了2ms，Java又行了！
 * see: https://mp.weixin.qq.com/s/UrZynlqi4QpyLlLhBPglyg
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0; // 滑动窗口内的元素之和
        int i = 0; // 滑动窗口的起始位置
        int subLength = 0; // 滑动窗口的长度
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 这里使用while循环，每次窗口收缩（更新i）后，判断子序列是否满足条件
            while (sum >= s) {
                subLength = j - i + 1; // 取窗口内子序列的长度
                result = Math.min(result, subLength); // 更新结果
                sum -= nums[i++]; // 滑动窗口（通过移动窗口左边界收缩窗口）
            }
        }
        // 如果result没有被赋值的话，说明没有找到符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
