package src.array.majorityelement169;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 19:52:07
 * description:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 *
 * 参考：https://leetcode-cn.com/problems/majority-element-ii/solution/mo-er-tou-piao-fa-jin-jie-ban-by-clearboy/
 */
public class Solution {
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0) majority = nums[i + 1];
            }
        }
        return majority;
    }
}
