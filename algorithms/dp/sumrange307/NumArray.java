package blogandquestion.algorithms.dp.sumrange307;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/02 20:31:27
 * description:
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 *
 * 有线段树的解法
 */
public class NumArray {
    // 执行时间67ms，击败了25%😂
    private int[] dp;
    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public void update(int i, int val) {
        int delta = dp[i] + val - dp[i + 1]; // 差值
        // 从i位置后依次更新dp数组
        for (int j = i + 1; j < dp.length; j++) {
            dp[j] = dp[j] + delta;
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}

/**
 * 最常见的解法，比dp要快。。。
 */
class NumArray1 {
    private int[] nums;
    public NumArray1(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int l = i; l <= j; l++) {
            sum += nums[l];
        }
        return sum;
    }

    public void update(int i, int val) {
        nums[i] = val;
    }
}
