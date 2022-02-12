package src.array.maxproduct1464;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 20:12:24
 * description:
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * 示例 2：
 *
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * 示例 3：
 *
 * 输入：nums = [3,7]
 * 输出：12
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array
 *
 */
public class Solution {
    // 可以直接调用库函数进行排序
    public int maxProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/solution/onjie-fa-by-tinylife/
 */
class AnotherSolution {
    // 题目限定了值都是大于1的
    public int maxProduct(int[] nums) {
        int cur = 0; // 使用cur保存最大值
        int prev = 0; // 使用prev保存次大值
        for (int i : nums) {
            if (i > cur) {
                // 如果当前元素值大于最大值cur，同时更行最大值和次大值
                int temp = cur;
                cur = i;
                prev = temp;
            } else if (i > prev) {
                // 否则比较当前元素与次大值
                prev = i;
            }
        }
        return (cur - 1) * (prev - 1);
    }
}
