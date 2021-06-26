package blogandquestion.algorithms.numbers.rotatearray.findmin153;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/26 10:48:49
 * description:
 */
public class ExerciseSolution2 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[r] > nums[l]) return nums[l];
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
