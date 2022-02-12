package src.array.jump45;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 20:59:45
 * description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 *
 * 参考：https://leetcode-cn.com/problems/jump-game-ii/solution/45-by-ikaruga/
 */
public class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                // 可以跳到的最远距离
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end; // 第一次可以从1开始尝试（下一次可以起跳的范围开始处）
            end = maxPos + 1; // 下一次可以起跳的范围的结束处
            res++;
        }
        return res;
    }
}
