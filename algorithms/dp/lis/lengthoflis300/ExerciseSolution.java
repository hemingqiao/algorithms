package blogandquestion.algorithms.dp.lis.lengthoflis300;

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
}
