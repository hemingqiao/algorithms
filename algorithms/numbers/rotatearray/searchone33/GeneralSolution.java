package blogandquestion.algorithms.numbers.rotatearray.searchone33;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/10 20:03:51
 * description: 一个通用的解决这四道旋转升序数组的思路
 */
public class GeneralSolution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            // 此时[left, mid]区间是有序的
            if (nums[mid] > nums[right]) {
                // 如果target落在了这个区间内
                if (target >= nums[left] && target < nums[mid]) {
                    // 将搜索的右边界收缩为mid - 1
                    right = mid - 1;
                } else {
                    // 否则，前往右边搜索
                    left = mid + 1;
                }
            } else { // 此处的else的条件相当于nums[mid] < nums[right]，因为题目限定不存在重复的数字，所以mid处的值不会等于right处的值
                // 此时[mid, right]区间是有序的
                // 如果target落在了这个区间内
                if (target > nums[mid] && target <= nums[right]) {
                    // 将搜索的左边界收缩为mid + 1
                    left = mid + 1;
                } else {
                    // 否则，前往左边搜索
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
