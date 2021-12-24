package blogandquestion.algorithms.binarysearch.searchrange34;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/07 10:49:38
 * description:
 */
public class ExerciseSolution2 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[]{-1, -1};
        int a = l;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{a, l};
    }
}
