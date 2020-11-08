package blogandquestion.algorithms.numbers.searchone33;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/08 20:47:53
 * description:
 * 给你一个升序排列的整数数组 nums ，和一个整数 target 。
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
 */
public class AnotherSolution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 如果前半部分有序
            // 等于是为了判断当只有两个数时的情况
            if (nums[left] <= nums[mid]) {
                // 如果target位于左边区间
                if (target >= nums[left] && target < nums[mid]) {
                    // 查找区间的右边界变为mid - 1
                    right = mid - 1;
                } else {
                    // target处于右边区间，查找区间的左边界变为mid + 1
                    left = mid + 1;
                }
            } else {
                // 后半部分有序
                if (target > nums[mid] && target <= nums[right]) { // 如果target位于右边区间
                    // 查找区间的左边界变为mid + 1
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
