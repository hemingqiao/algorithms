package src.array.canjump55;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/26 20:34:05
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/55
 */
public class ExerciseSolution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = 0;
        for (int i = 0; i < n; i++) {
            if (i > reach || reach >= n - 1) break;
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= n - 1;
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int reach = 0;
        for (int i = 0; i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (reach >= n - 1) return true;
        }
        return false;
    }
}
