package src.numbers.findmaxconsecutiveones485;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 19:28:09
 * description:
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 *
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        // 如果数组中元素都为1，那么就不能进入比较大小的else语句，所以需要再跳出循环时将max和count做一次比较
        return Math.max(max, count);
    }
}

class AnotherSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int max = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0) {
                max = Math.max(max, right - left);
                left = right + 1;
            }
        }
        // 同样地，在跳出循环后要再进行一次判断，因为数组中的元素可能都为1
        return Math.max(max, right - left);
    }
}
