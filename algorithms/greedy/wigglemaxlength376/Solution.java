package blogandquestion.algorithms.greedy.wigglemaxlength376;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/03 13:51:04
 * description:
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 *
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 *
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * 进阶:
 * 你能否用 O(n) 时间复杂度完成此题?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 *
 * 参考：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bu-zhi-dao-shi-bu-shi-shu-yu-dong-tai-gui-hua-fan-/
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int curDiff = 0; // 当前一对元素的差值
        int preDiff = 0; // 前一对元素的差值
        int res = 1;
        // (cur > 0 && pre <= 0) || (cur < 0 && pre >= 0) 这个判断条件，发生波峰下降或者波谷上升的时候，进入累加的逻辑里面，
        // 并且除了一开始的平峰会记录pre = 0，其他时候，平峰都不会统计，所以发生一次变化之后，pre不再可能为 0 了。
        // 所以pre <= 0 和 pre >= 0，那个等于号只有第一次变化的时候才有生效。
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if (curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}
