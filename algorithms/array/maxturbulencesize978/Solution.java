package blogandquestion.algorithms.array.maxturbulencesize978;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/08 08:21:06
 * description:
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 *
 * 参考：https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/qing-xi-yi-dong-de-dong-tai-gui-hua-jie-fa-shi-yon/
 */
public class Solution {
    /*
    // 错误解法
    public int maxTurbulenceSize(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        int[] dp = new int[n - 1];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n - 1; i++) {
            if (diff[i - 1] * diff[i] < 0) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    */

    public int maxTurbulenceSize(int[] nums) {
        int n = nums.length;
        int[] dec = new int[n], inc = new int[n];
        Arrays.fill(dec, 1);
        Arrays.fill(inc, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                dec[i] = inc[i - 1] + 1;
            } else if (nums[i - 1] < nums[i]) {
                inc[i] = dec[i - 1] + 1;
            }
            res = Math.max(res, Math.max(dec[i], inc[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] test = new int[]{9,4,2,10,7,8,8,1,9};
        int[] test = new int[]{100, 100, 100};
        int res = s.maxTurbulenceSize(test);
        System.out.println(res);
    }
}
