package src.array.finderrornums645;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/04 09:19:23
 * description:
 */
public class ExerciseSolution {
    // 原地算法
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (nums[a - 1] < 0) ret[0] = a;
            nums[a - 1] *= -1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && i + 1 != ret[0]) ret[1] = i + 1;
        }
        return ret;
    }
}
