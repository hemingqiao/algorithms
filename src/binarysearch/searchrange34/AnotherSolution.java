package src.binarysearch.searchrange34;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/24 19:35:57
 * description:
 */
public class AnotherSolution {
    // 这一题和 ./searchlcof53 基本相同
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int start = left;
        for (; start < nums.length - 1; start++) {
            if (nums[start] != nums[start + 1]) {
                break;
            }
        }
        return new int[]{left, start};
    }
}
