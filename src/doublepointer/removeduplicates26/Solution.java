package src.doublepointer.removeduplicates26;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/16 22:12:33
 * description: 双指针解法，使用快慢双指针
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * 解题思路
 * see: https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/yuan-di-xiu-gai-shu-zu
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int fast =0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护nums[0 ... slow]无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组的长度为索引 + 1
        return slow + 1;
    }
}
