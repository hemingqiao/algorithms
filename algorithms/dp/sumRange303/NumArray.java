package blogandquestion.algorithms.dp.sumRange303;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/06 19:33:57
 * description: 利用构造器将sumRange(0, k)的和预先求出来并缓存到一个数组中，这样后面的计算的时间复杂度就是O(1)了
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
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
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
