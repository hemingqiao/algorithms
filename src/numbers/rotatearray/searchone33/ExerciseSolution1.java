package src.numbers.rotatearray.searchone33;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/21 22:00:15
 * description:
 */
public class ExerciseSolution1 {
    // 大雪菜讲解
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (nums[mid] > nums[0]) l = mid;
            else r = mid - 1;
        }
        if (target >= nums[0]) {
            l = 0;
        } else {
            l = r + 1;
            r = nums.length - 1;
        }
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        // 这里用了r而不是l，是因为在第一个二分中，l == r 可能等于nums.length - 1，l = r + 1导致l可能数组越界
        if (nums[r] == target) return r;
        return -1;
    }
}
