package src.greedy.jumptwo45;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 10:06:23
 * description:
 *
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
 * 解题思路：
 * 每次都跳到一个使得下次跳跃最远的位置，遍历下一次能够调到的范围，确定跳到范围内的何处使得下一次跳跃最远。
 * see: https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
 * see: https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
 */
public class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        // 在遍历数组时，不需要访问最后一个元素，这是因为在访问最后一个元素之前，边界一定是大于等于最后一个位置的，
        // 否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，会增加一次「不必要的跳跃次数」，
        // 因此不必访问最后一个元素。
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
