package src.dp.lis.lengthoflis300;



/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/30 20:24:29
 * description:
 * 二刷（这题还是毫无思路）
 */
public class ExerciseSolution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            int cur = nums[i];
            for (int j = 0; j < i; j++) {
                if (cur > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 不是很理解
    // 参考：https://leetcode-cn.com/problems/longest-increasing-subsequence/comments/10526
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            // 二分查找，找到dp数组中第一个大于等于nums[i]的位置，类似于c++中的lower_bound函数
            int left = 0, right = max;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (dp[mid] >= nums[i]) right = mid;
                else left = mid + 1;
            }
            dp[left] = nums[i];
            if (left == max) max++;
        }
        return max;
    }
}
