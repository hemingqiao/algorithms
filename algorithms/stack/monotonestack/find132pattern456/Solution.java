package blogandquestion.algorithms.stack.monotonestack.find132pattern456;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/24 13:30:33
 * description:
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 *
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 *
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 10^4
 * -109 <= nums[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 *
 * 参考：https://github.com/grandyang/leetcode/issues/456
 */
public class Solution {
    /*
    思路是维护一个栈和一个变量 third，其中 third 就是第三个数字，也是 pattern 132 中的2，初始化为整型最小值，栈里面按顺序放所有大于 third
    的数字，也是 pattern 132 中的3，那么在遍历的时候，如果当前数字小于 third，即 pattern 132 中的1找到了，直接返回 true 即可，因为已经找
    到了，注意应该从后往前遍历数组。如果当前数字大于栈顶元素，那么将栈顶数字取出，赋值给 third，然后将该数字压入栈，这样保证了栈里的元素仍然都是
    大于 third 的，想要的顺序依旧存在，进一步来说，栈里存放的都是可以维持坐标 second > third 的 second 值，其中的任何一个值都是大于当前的
    third 值，如果有更大的值进来，那就等于形成了一个更优的 second > third 的这样一个组合，并且这时弹出的 third 值比以前的 third 值更大，
    为什么要保证 third 值更大，因为这样才可以更容易的满足当前的值 first 比 third 值小这个条件，举个例子来说吧，比如 [2, 4, 2, 3, 5]，由
    于是从后往前遍历，所以后三个数都不会进入 while 循环，那么栈中的数字为 5, 3, 2（其中2为栈顶元素），此时 third 还是整型最小，那么当遍历到
    4的时候，终于4大于栈顶元素2了，那么 third 赋值为2，且2出栈。此时继续 while 循环，因为4还是大于新栈顶元素3，此时 third 赋值为3，且3出
    栈。现在栈顶元素是5，那么 while 循环结束，将4压入栈。下一个数字2，小于 third，则找到符合要求的序列 [2, 4, 3]
     */
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        for (int j = n - 1; j >= 0; j--) {
            // 栈非空保证存在比third大的元素，同时nums[j] < third，就保证了132模式的成立
            if (!stack.isEmpty() && nums[j] < third) return true;
            // 栈顶元素小于当前元素时退出while循环
            while (!stack.isEmpty() && nums[j] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(nums[j]);
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            // int fixed = nums[i];
            // for (int j = i + 1; j < n; j++) {
            //     int fixed2 = nums[j];
            //     for (int k = j + 1; k < n; k++) {
            //         if (fixed < nums[k] && nums[k] < fixed2) return true;
            //     }
            // }
            int fixed = nums[i];
            int leftMin = fixed, rightMax = Integer.MIN_VALUE;
            // 找到当前元素左边小于当前元素的最小的元素
            for (int j = 0; j < i; j++) {
                if (nums[j] < fixed) leftMin = Math.min(leftMin, nums[j]);
            }
            // 找到当前元素右边小于当前元素的最大的元素
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < fixed) rightMax = Math.max(rightMax, nums[j]);
            }
            if (leftMin < fixed && rightMax > leftMin) return true;
        }
        return false;
    }

    // 参考：https://github.com/grandyang/leetcode/issues/456
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            if (min == nums[i]) continue;
            for (int j = n - 1; j > i; j--) {
                if (min < nums[j] && nums[j] < nums[i]) return true;
            }
        }
        return false;
    }
}
