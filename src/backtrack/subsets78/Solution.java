package src.backtrack.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/13 20:16:04
 * description: 求解幂集。
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247485402&idx=1&sn=6963af3e2aa8d58e41b71d73d53ea8f6&scene=21#wechat_redirect
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path)); // 收集子集
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = s.subsets(nums);
        System.out.println(res);
    }
}
