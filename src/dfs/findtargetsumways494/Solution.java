package src.dfs.findtargetsumways494;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/26 21:34:07
 * description:
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *  
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 *
 */
public class Solution {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        dfs(nums, S, 0);
        return cnt;
    }

    private void dfs(int[] nums, int target, int p) {
        // 当已经遍历完nums数组时，结束递归
        if (p == nums.length) {
            if (target == 0) {
                cnt++;
            }
            return;
        }
        // 深度优先搜索时，每一层有两个选择（分支）：加上当前位置的值或者减去当前位置的值
        dfs(nums, target - nums[p], p + 1);
        dfs(nums, target + nums[p], p + 1);
    }
}
