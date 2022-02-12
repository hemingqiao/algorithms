package src.stack.monotonestack.nextgreaterelements503;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 16:53:57
 * description:
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 *
 * 参考：https://github.com/grandyang/leetcode/issues/503
 */
public class Solution {
    // 暴力求解，有更好的解法，写不动了今天。
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > nums[i]) {
                    ret[i] = nums[j % n];
                    break;
                }
            }
        }
        return ret;
    }
}
