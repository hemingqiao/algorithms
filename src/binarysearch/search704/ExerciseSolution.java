package src.binarysearch.search704;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/06 21:33:47
 * description:
 */
public class ExerciseSolution {
    // 这种写法相比而言处理要麻烦一些
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == n || nums[left] != target) return -1;
        if (nums[left] == target) return left;
        return -1;
    }
}
