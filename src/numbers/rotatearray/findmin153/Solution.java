package src.numbers.rotatearray.findmin153;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/10 08:30:17
 * description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 解题思路
 * see: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/tong-guo-hua-tu-geng-neng-shen-ke-li-jie-er-fen-fa/
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 当数组只有一个元素时，就不进入循环
        while (left < right) {
            int mid = (left + right) / 2;
            // 如果mid处的值小于右边界处的值，说明mid落在了右边的有序区间内
            // 同时此时并不能排除掉mid就是最小值位置的可能，所以right收缩为mid
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

class AnotherSolution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 判断条件是小于等于，便于处理只有一个元素等情况
        while (left <= right) {
            // 如果从left到right是递增的，直接返回left处的值
            if (nums[left] <= nums[right]) return nums[left];
            int mid = (left + right) / 2;
            // 如果left处的值小于等于mid处的值，说明区间[left, right]内是连续递增的，最小值一定不在这个区间内
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                // 否则，说明区间[left, right]不是连续的，最小值一定位于这个区间内，同时，不能排除mid就是最小值的可能性
                // 所以right收缩为mid，在[left, mid]区间内继续搜索
                right = mid;
            }
        }
        return -1;
    }
}
