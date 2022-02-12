package src.numbers.movezeroes283;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/17 22:04:31
 * description:
 */
public class ExerciseSolution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int fast = 0, slow = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < n) {
            nums[slow++] = 0;
        }
    }

    // in-place解法
    // 参考：https://github.com/grandyang/leetcode/issues/283
    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j++);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
