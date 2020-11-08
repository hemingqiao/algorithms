package blogandquestion.algorithms.numbers.searchtwo81;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/08 16:41:19
 * description:
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // 因为数组存在重复数字，如果中点和左端的数字相同，我们并不能确定是左区间全部
            // 相同，还是右区间完全相同。在这种情况下，我们可以简单地将左端点右移一位，然后继续进行
            // 二分查找。
            if (nums[mid] == nums[start]) {
                ++start;
            } else if (nums[mid] <= nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
