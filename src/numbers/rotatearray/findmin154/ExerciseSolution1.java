package src.numbers.rotatearray.findmin154;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/20 20:50:07
 * description:
 */
public class ExerciseSolution1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (r > 0 && nums[r] == nums[l]) r--;
        // 判断数组是否只有一段（数组存在两段才能利用二段性来二分）。如[1, 2, 1]
        if (nums[l] <= nums[r]) return nums[l];
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
