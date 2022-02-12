package src.array.longestsubarray1438;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/21 11:11:55
 * description:
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 *
 */
public class Solution {
    // TLE
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int[][] diff = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = Math.abs(nums[i] - nums[j]);
            }
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean flag = true;
                if (!check(diff, i, j, limit)) flag = false;
                if (flag) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public boolean check(int[][] diff, int start, int end, int limit) {
        boolean res = true;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (diff[i][j] > limit) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{4, 2, 2, 2};
        int res = s.longestSubarray(test, 0);
        System.out.println(res);
    }


    // 需要快速的找到窗口内的最大值和最小值
    // 这里使用了TreeMap
    public int longestSubarray1(int[] nums, int limit) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 1;
        int left = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    // 还可以使用两个双端队列分别保存窗口内的最大值和最小值的索引
    // 参考：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/xiang-jie-er-fen-hua-dong-chuang-kou-dan-41g1/
    // 参考：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/liang-chong-jie-fa-hua-dong-chuang-kou-t-sruu/
    public int longestSubarray2(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        int left = 0;
        int res = 1;
        for (int i = 0; i < n; i++) {
            while (!max.isEmpty() && nums[i] >= nums[max.peekLast()]) max.pollLast();
            while (!min.isEmpty() && nums[i] <= nums[min.peekLast()]) min.pollLast();
            max.add(i);
            min.add(i);
            // 调整窗口左边界
            while (Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit) {
                left++;
                if (max.peekFirst() < left) max.pollFirst();
                if (min.peekFirst() < left) min.pollFirst();
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
