package blogandquestion.algorithms.numbers.searchrange34;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/07 10:38:39
 * description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        // 左闭右闭区间
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 初始化结果数组
                int[] res = new int[]{mid, mid};
                for (int i = mid + 1; i < nums.length; i++) {
                    if (nums[i] != target) {
                        // 找到第一个不等于target的索引
                        break;
                    } else {
                        res[1] = i;
                    }
                }
                for (int i = mid - 1; i >= 0; i--) {
                    if (nums[i] != target) {
                        // 找到第一个值不等于target的索引
                        break;
                    } else {
                        res[0] = i;
                    }
                }
                return res;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = s.searchRange(test, target);
        System.out.println(Arrays.toString(res));
    }
}
