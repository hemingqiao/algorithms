package src.backtrack.combinationsum377;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/24 10:16:27
 * description:
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *  
 *
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 *
 */
public class Solution {
    private int cnt = 0;

    // 递归+回溯会TLE
    public int combinationSum4(int[] nums, int target) {
        dfs(new ArrayList<>(), nums, 0, target);
        return cnt;
    }

    public void dfs(List<Integer> path, int[] nums, int sum, int target) {
        if (sum >= target) {
            if (sum == target) {
                ++cnt;
                System.out.println(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            dfs(path, nums, sum, target);
            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }
}
