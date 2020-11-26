package blogandquestion.algorithms.array.maximumgap164;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 12:57:42
 * description:
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 *
 */
public class Solution {
    // 不考虑题目对时间复杂度和空间复杂度的要求，直接暴力排序，在进行查找
    // 竟然击败了99.72。。
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] - nums[i - 1];
            if (temp > max) {
                max = temp;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}

class AnotherSolution {
    // 看了一些题解，都是桶排序，这次就不讲武德了，下次再说
    public int maximumGap(int[] nums) {
        return -1;
    }
}
