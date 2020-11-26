package blogandquestion.algorithms.doublepointer.maxproduct152;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 22:15:26
 * description:
 * 参考：https://leetcode-cn.com/problems/maximum-product-subarray/solution/duo-chong-si-lu-qiu-jie-by-powcai-3/
 */
public class AnotherSolution {
    // 只要记录前i的最小值, 和最大值, 那么 dp[i] = max(nums[i] * pre_max, nums[i] * pre_min, nums[i]),
    // 在这里0 不需要单独考虑, 因为当零和最大值或最小值相乘,都会置0

    // 求数组中子区间的最大乘积，对于乘法，需要注意，负数乘以负数，会变成正数，所以解这题的时候需要维护两个变量，
    // 当前的最大值，以及最小值，最小值可能为负数，但没准下一步乘以一个负数，当前的最大值就变成最小值，而最小值则变成最大值了
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int pre_max = nums[0];
        int pre_min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur_max = Math.max(Math.max(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            int cur_min = Math.min(Math.min(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            res = Math.max(res, cur_max);
            pre_max = cur_max;
            pre_min = cur_min;
        }
        return res;
    }
}
