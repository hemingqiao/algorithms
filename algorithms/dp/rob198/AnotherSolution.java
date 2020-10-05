package blogandquestion.algorithms.dp.rob198;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 10:33:14
 * description:
 * see: https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
 */
public class AnotherSolution {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;

        for (int num : nums) {
            // 循环开始时，prev代表dp[k - 2]，curr代表dp[k - 1]
            // dp[k] = max(dp[k - 1], dp[k - 2] + nums[k])
            int temp = Math.max(prev + num, curr);
            prev = curr;
            curr = temp;
            // 循环结束时，prev代表dp[k - 1]，curr代表dp[k]
        }
        return curr;
    }
}