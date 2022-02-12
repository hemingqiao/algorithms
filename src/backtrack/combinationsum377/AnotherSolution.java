package src.backtrack.combinationsum377;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/24 10:19:17
 * description:
 */
public class AnotherSolution {
    // WA
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, target, memo);
    }

    public int dfs(int[] nums, int target, Map<Integer, Integer> memo) {
        if (target < 0) return 0;
        if (target == 1) return 1;
        if (memo.containsKey(target)) return memo.get(target);
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            res += dfs(nums, target - nums[i], memo);
        }
        memo.put(target, res);
        return res;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        int[] test = new int[]{1, 2, 3};
        int res = as.combinationSum4(test, 4);
        System.out.println(res);
    }

    // 参考：https://github.com/grandyang/leetcode/issues/377
    public int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int a : nums) {
                if (i >= a) dp[i] += dp[i - a];
            }
        }
        return dp[target];
    }
}
