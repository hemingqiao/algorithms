package src.array.findmaxlength525;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/03 20:38:30
 * description:
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 *
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        // map的key为前缀和，value为该前缀和对应的下标，一般而言，前缀和从1开始计算，所以-1下标对应前缀和为0
        // 如果某个前缀和(下标设为prevIndex)在之前出现过，则表明这两个索引(prevIndex + 1, index)之间的元素和为0
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, count = 0;
        map.put(count, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) count++;
            else count--;
            if (map.containsKey(count)) {
                res = Math.max(res, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return res;
    }

    // TLE
    public int findMaxLength1(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i] == 1 ? 1 : -1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == 1) sum++;
                else sum--;
                if (sum == 0) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
