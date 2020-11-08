package blogandquestion.algorithms.numbers.searchtwo81;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/08 21:00:15
 * description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
 */
public class AnotherSolution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 因为存在可能的重复数字，如 10111 和 11101 这种情况。
            // 此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。
            // 相当于去掉一个重复的干扰项。然后继续进行二分查找
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            // 左边区间有序
            if (nums[left] <= nums[mid]) {
                // 目标值位于左边区间
                if (target >= nums[left] && target < nums[mid]) {
                    // 搜索右边界变为mid - 1
                    right = mid - 1;
                } else {
                    // 否则，前往右边区间搜索
                    left = mid + 1;
                }
            } else {
                // 右边区间有序
                if (target > nums[mid] && target <= nums[right]) { // 目标值位于右边区间
                    // 搜索左边界变为mid + 1
                    left = mid +  1;
                } else {
                    // 否则，前往左边区间搜索
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
