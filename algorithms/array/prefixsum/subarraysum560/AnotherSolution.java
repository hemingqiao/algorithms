package blogandquestion.algorithms.array.prefixsum.subarraysum560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 19:41:14
 * description:
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 *
 * 参考：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
 * 参考：https://www.cxyxiaowu.com/11326.html
 */
public class AnotherSolution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int preSum = 0;
        map.put(0, 1); // 前缀和为0的数量是1
        for (int num : nums) {
            preSum += num;
            // preSum - (preSum - k) == k
            // 前缀和为preSum - k时，刚好可以凑成和为k
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1); // 前缀和为preSum的数量加1
        }
        return res;
    }
}
