package src.array.findunsortedsubarray581;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 19:26:41
 * description:
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 *
 * 参考：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
 */
public class Solution {
    public int findUnsortedSubArray(int[] nums) {
        int len = nums.length;
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        // 或者可以调用clone方法
        //int[] copy = nums.clone();
        Arrays.sort(copy);
        int left = 0, right = len - 1;
        while (left <= right && nums[left] == copy[left]) {
            left++;
        }
        while (left <= right && nums[right] == copy[right]) {
            right--;
        }
        return right - left + 1;
    }
}
