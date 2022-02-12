package src.dfs.findtargetsumways494;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/07 20:40:55
 * description:
 */
public class ExerciseSolution {
    int cnt = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        return cnt;
    }

    public void dfs(int[] nums, int sum, int target, int index) {
        if (index == nums.length) {
            if (sum == target) ++cnt;
            return;
        }
        dfs(nums, sum + nums[index], target, index + 1);
        dfs(nums, sum - nums[index], target, index + 1);
    }
}
