package blogandquestion.algorithms.numbers.rotatearray.searchtwo81;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/07 13:05:21
 * description:
 */
public class ExerciseSolution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[right]) {
                right--;
                continue;
            }
            if (nums[mid] > nums[right]) { // 区间[left, mid]有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 区间[mid, right]有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    // 和最左边的值作比较也是可以的
    public boolean search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left]) {
                ++left;
                continue;
            }
            if (nums[mid] < nums[left]) {
                // 此时区间[mid, right]是有序的，判断target是否位于有序的区间内
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 此时区间[left, mid]是有序的，首先判断target是否位于有序区间内
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
