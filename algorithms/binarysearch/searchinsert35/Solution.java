package blogandquestion.algorithms.numbers.binarysearch.searchinsert35;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/07 11:16:06
 * description: target的位置是大于等于target的第一个元素的位置（如果数组中存在目标值，target的位置就是等于target的位置，否则
 * target插入到数组中第一个大于它的元素的位置）
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 *
 * 解题思路，非常经典和优秀的二分法题解
 * see: https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        // 特判
        if (nums[len - 1] < target) return len;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
