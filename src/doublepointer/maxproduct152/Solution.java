package src.doublepointer.maxproduct152;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 21:38:35
 * description:
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 *
 */
public class Solution {
    /**
     * 正确解法
     * @param nums
     * @return
     */
    public int maxProductOpt(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; // 一个保存最大的，一个保存最小的。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            // 如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}


class ThirdSolution {
    // 参考：https://leetcode-cn.com/problems/maximum-product-subarray/solution/dpfang-fa-xiang-jie-by-yang-cong-12/387808
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = nums[0];
        //两个mDP分别定义为以i结尾的子数组的最大积与最小积；
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        //初始化DP；
        maxDP[0] = nums[0];
        minDP[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //最大积的可能情况有：元素i自己本身，上一个最大积与i元素累乘，上一个最小积与i元素累乘；
            //与i元素自己进行比较是为了处理i元素之前全都是0的情况；
            maxDP[i] = Math.max(nums[i], Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(nums[i], Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            //记录ans；
            ans = Math.max(ans, maxDP[i]);
        }
        return ans;
    }
}
