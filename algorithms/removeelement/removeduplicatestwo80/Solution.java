package blogandquestion.algorithms.removeelement.removeduplicatestwo80;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/14 19:36:42
 * description:
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 *
 * 解题思路：应和第26题放在一起理解。第26题要求不能存在重复元素，这题要求每个元素最多出现两次。那么可以维护一个计数器，记录同一个
 * 元素出现的次数，如果小于等于两次，可以放入数组，否则，原地删除。每当两个元素不等时，重置计数器为0。
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
                count = 0;
            } else {
                if (count < 1) {
                    nums[++index] = nums[i];
                }
                count++;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 1, 1, 2, 2, 3};
        int result = s.removeDuplicates(test);
        System.out.println(result);
    }
}
