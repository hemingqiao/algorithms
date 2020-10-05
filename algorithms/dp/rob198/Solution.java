package blogandquestion.algorithms.dp.rob198;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 10:09:00
 * description:
 * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
 * see: https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 1};
        int result = new Solution().rob(test);
        System.out.println(result);
    }
}
