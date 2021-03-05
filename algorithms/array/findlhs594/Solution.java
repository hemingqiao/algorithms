package blogandquestion.algorithms.array.findlhs594;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/05 16:45:08
 * description:
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 *
 * 参考：https://github.com/grandyang/leetcode/issues/594
 */
public class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }

    // brute force
    public int findLHS1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int fixed = nums[i];
            int right = i;
            int max = nums[i];
            while (right < n && nums[right] - fixed <= 1) {
                max = Math.max(max, nums[right]);
                ++right;
            }
            if (max - fixed == 1) {
                res = Math.max(res, right - i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1,3,2,2,5,2,3,7};
        int res = s.findLHS1(test);
        System.out.println(res);
    }
}
