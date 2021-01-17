package blogandquestion.algorithms.array.thirdmax414;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 15:17:03
 * description:
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 231 <= nums[i] <= 231 - 1
 *  
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 *
 * 参考：https://github.com/grandyang/leetcode/issues/414
 */
public class Solution {
    public int thirdMax(int[] nums) {
        long min = Long.MIN_VALUE;
        long first = min, second = min, third = min;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t > first) {
                // 注意顺序，不能倒过来先将t赋值给first，在将first赋值给second
                third = second;
                second = first;
                first = t;
            } else if (t < first && t > second) {
                third = second;
                second = t;
            } else if (t < second && t > third) {
                third = t;
            }
        }
//        return (int) ((third == Long.MIN_VALUE || third == second) ? first : third);
        // 要么不存在严格第三大的数（即third == Long.MIN_VALUE），要么存在严格第三大的数
        return (int) (third == min ? first : third);
    }
}
