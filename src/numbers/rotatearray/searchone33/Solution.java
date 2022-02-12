package src.numbers.rotatearray.searchone33;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/08 19:56:09
 * description:
 */
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // 题目设定，每个值都是独一无二的，所以不需要判断是否有重复的值
            if (nums[mid] == target) {
                return mid;
            }
            // 如果mid处的值小于等于最右侧的值，表明右侧是有序的
            if (nums[mid] <= nums[end]) {
                // 如果目标值处于大于mid处的值且小于最右侧的值，就可以在右侧区间进行查找
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    // 否则转回左侧区间
                    end = mid - 1;
                }
            } else {
                // 反之，mid左侧的区间是有序的
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
