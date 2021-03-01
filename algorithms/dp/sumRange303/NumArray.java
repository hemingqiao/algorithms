package blogandquestion.algorithms.dp.sumRange303;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/06 19:33:57
 * description: 利用构造器将sumRange(0, k)的和预先求出来并缓存到一个数组中，这样后面的计算的时间复杂度就是O(1)了
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 *
 */
public class NumArray {
    private int[] sums = null;

    public NumArray(int[] nums) {
        if (nums != null && nums.length > 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        }
        // 这里用到了动态规划的思想
        // sumRange(i, j) = sumRange(0, j) - sumRange(0, i - 1)
        return sums[j] - sums[i - 1];
    }
}

/**
 * 改为了dp数组形式
 */
class AnotherSolution {
    private int[] dp;
    public AnotherSolution(int[] nums) {
        if (nums.length == 0) return;
        int len = nums.length;
        dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}

/*
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
