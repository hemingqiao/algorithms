package src.array.findunsortedsubarray581;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/03 20:57:57
 * description:
 */
public class ExerciseSolution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l + 1 < n && nums[l] <= nums[l + 1]) l++;
        if (l == r) return 0;
        while (r - 1 > 0 && nums[r] >= nums[r - 1]) r--;
        for (int i = l + 1; i < n; i++) {
            while (l >= 0 && nums[l] > nums[i]) l--;
        }
        for (int i = r - 1; i >= 0; i--) {
            while (r < n && nums[r] < nums[i]) r++;
        }
        return r - l - 1; // 不包含r和l
    }
}
