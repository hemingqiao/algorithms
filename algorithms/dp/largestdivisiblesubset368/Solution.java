package blogandquestion.algorithms.dp.largestdivisiblesubset368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/23 13:34:47
 * description:
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 *
 * 参考：https://github.com/grandyang/leetcode/issues/368
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // dp[i]表示数字nums[i]位置处到序列末尾这段区间内最大可整除的子集合长度
        // parent数组用来记录上一个能整除的数字的位置
        int[] dp = new int[n], parent = new int[n];
        List<Integer> res = new ArrayList<>();
        int max = 0, max_idx = 0; // max_idx记录起始数字的位置
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if (max < dp[i]) {
                        max = dp[i];
                        max_idx = i;
                    }
                }
            }
        }
        for (int i = 0; i < max; i++) {
            res.add(nums[max_idx]);
            max_idx = parent[max_idx];
        }
        return res;
    }
}
