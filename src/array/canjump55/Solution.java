package src.array.canjump55;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 20:33:43
 * description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 *
 * 参考：https://leetcode-cn.com/problems/jump-game/solution/55-tiao-yue-you-xi-tan-xin-jing-dian-ti-mu-xiang-j/
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int cover = 0; // cover表示能跳到的最大范围
        if (nums.length == 1) return true;
        for (int i = 0; i <= cover; i++) {
            // 判断是否需要更新cover，当前位置加上当前位置的值就是一个新的cover，和之前的cover取一个最大值
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {3, 2, 1, 0, 4, 2, 1};
        boolean res = s.canJump(test);
        System.out.println(res);
    }
}
