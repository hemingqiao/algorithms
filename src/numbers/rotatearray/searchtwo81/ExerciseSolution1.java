package src.numbers.rotatearray.searchtwo81;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/21 22:28:15
 * description:
 */
public class ExerciseSolution1 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int R = nums.length - 1;
        // 从末尾删除所有和开头相同的元素
        while (R >= 0 && nums[R] == nums[0]) R--;
        // 如果R小于0，表明数组中的元素都相等
        if (R < 0) return nums[0] == target;
        int l = 0, r = R;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }
        if (target >= nums[0]) l = 0;
        else {
            l = r + 1;
            r = R;
        }
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[r] == target;
    }
}
