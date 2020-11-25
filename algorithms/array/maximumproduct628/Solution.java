package blogandquestion.algorithms.array.maximumproduct628;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 22:06:55
 * description:
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 *
 * 这题和maxProduct1464很类似
 */
public class Solution {
    // 调用库函数排序方法
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // 最小值会存在比较大的负值，由于是三个数的乘积，所以如果结果中有负数，只可能是最小的两个负数
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 3] * nums[len - 2] * nums[len - 1]);
    }
}

class AnotherSolution {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        // 因为数组中存在负数，所以要判断三个数乘积的最大值
        // 需要找到最小, 第二小, 最大, 第二大, 第三大的元素值
        // 最小值初始化为最大，最大值初始化为最小
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min2) {
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else {
                    min2 = num;
                }
            }
            if (num > max3) {
                if (num > max2) {
                    if (num > max1) {
                        max3 = max2;
                        max2 = max1;
                        max1 = num;
                    } else {
                        max3 = max2;
                        max2 = num;
                    }
                } else {
                    max3 = num;
                }
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
