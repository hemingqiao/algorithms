package src.doublepointer.maxproduct152;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/02 21:40:17
 * description:
 */
public class ExerciseSolution {
    // 如果数组中不包含负数的话，那么以i处元素结尾的最大子数组乘积由两个状态转移而来：
    // dp[i] = max(nums[i], dp[i - 1] * nums[i]
    // 而当数组中存在负数时，正数可能变为负数，而负数乘上一个负数又会变为正数，所以需要用两个dp数组分别记录最大值和最小值
    // 并在遍历过程中维护这两个数组
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] min_dp = new int[n];
        int[] max_dp = new int[n];
        min_dp[0] = nums[0];
        max_dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            max_dp[i] = Math.max(nums[i], Math.max(min_dp[i - 1] * nums[i], max_dp[i - 1] * nums[i]));
            min_dp[i] = Math.min(nums[i], Math.min(min_dp[i - 1] * nums[i], max_dp[i - 1] * nums[i]));
            res = Math.max(res, max_dp[i]);
        }
        return res;
    }

    // 这个解法更为简洁一些，没有再维护两个dp数组，而是直接动态的维护了一个最大值和一个最小值
    public int maxProduct1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int pre_max = nums[0];
        int pre_min = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int cur_max = Math.max(Math.max(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            int cur_min = Math.min(Math.min(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            res = Math.max(res, cur_max);
            pre_max = cur_max;
            pre_min = cur_min;
        }
        return res;
    }
}
