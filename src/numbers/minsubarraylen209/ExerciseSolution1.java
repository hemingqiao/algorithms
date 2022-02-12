package src.numbers.minsubarraylen209;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/29 22:21:43
 * description:
 */
public class ExerciseSolution1 {
    // 前缀和暴力解法 O(n^2)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = nums[i - 1] + s[i - 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (s[i] - s[j] >= target) ans = Math.min(ans, i - j);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 双指针 O(n)
    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            while (sum - nums[j] >= target) sum -= nums[j++];
            if (sum >= target) ans = Math.min(ans, i - j + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
