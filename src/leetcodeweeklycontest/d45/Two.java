package src.leetcodeweeklycontest.d45;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/07 08:36:43
 * description:
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 *
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 *
 * abs(x) 定义如下：
 *
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * 示例 2：
 *
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-absolute-sum-of-any-subarray
 *
 */
public class Two {
    // 暴力解法会TLE，
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                res = Math.max(res, Math.abs(sum));
            }
            sum = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Two t = new Two();
        int[] test = new int[]{1,-3,2,3,-4};
        int res = t.maxAbsoluteSum(test);
        System.out.println(res);
    }

    // 分别记录最小值和最大值，最后比较两者的绝对值
    // 对于最小值，如果之前的min值大于等于0，不会使最小值变得更小，需要舍弃之前的和，将最小值置为当前值
    // 同理对于最大值，如果之前的max值小于等于0，对最大值是没有增益的，需要舍弃之前的和，将最大值置为当前值
    // 可以类比53题，max和min分别记录以i结尾的子数组和的最大值和最小值
    public int maxAbsoluteSum1(int[] nums) {
        int n = nums.length;
        int min = 0, max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (min >= 0) min = t;
            else min += t;
            if (max <= 0) max = t;
            else max += t;
            res = Math.max(res, Math.abs(min));
            res = Math.max(res, Math.abs(max));
        }
        return res;
    }
}
