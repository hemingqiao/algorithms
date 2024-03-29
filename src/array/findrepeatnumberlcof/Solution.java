package src.array.findrepeatnumberlcof;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/23 13:28:14
 * description:
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 */
public class Solution {
    // 如果长度过大，可以改用哈希表
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] record = new int[n];
        for (int num : nums) {
            if (record[num] == 0) {
                record[num]++;
            } else {
                return num;
            }
        }
        return 0;
    }
}
