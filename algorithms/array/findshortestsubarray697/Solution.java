package blogandquestion.algorithms.array.findshortestsubarray697;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/18 19:52:24
 * description:
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 *
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int degree = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Pair> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
                map1.put(temp, new Pair(i, i));
            } else {
                map.put(temp, map.get(temp) + 1);
                map1.get(temp).second = i;
            }
            degree = Math.max(degree, map.get(temp));
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == degree) {
                Pair p = map1.get(entry.getKey());
                res = Math.min(res, p.second - p.first + 1);
            }
        }
        return res;
    }

    static class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
