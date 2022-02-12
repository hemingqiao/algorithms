package src.array.prefixsum.numberofsubarrays1248;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/16 17:03:02
 * description:
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 *
 * 参考：https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/hashmap-by-yun-fei-ing-4dm7/
 * 参考：https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/qian-zhui-he-hash-jian-dan-yi-li-jie-by-aleix/
 */
public class Solution {
    // 为什么要把0处的值初始化为1，不是很明白
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        // map的key代表区间含有多少个奇数，value代表的是含有key个奇数的区间的个数3
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // ?? 出现奇数个数为0 的子数组肯定包括空  次数加一
        int oddCount = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            oddCount += nums[i] & 1;
            if (map.containsKey(oddCount - k)) cnt += map.get(oddCount - k);
            if (map.containsKey(oddCount)) {
                map.put(oddCount, map.get(oddCount) + 1);
            } else {
                map.put(oddCount, 1);
            }
        }
        return cnt;
    }

    // 用数组替代哈希表
    public int numberOfSubarrays1(int[] nums, int k) {
        int n = nums.length;
        // map的key代表区间含有多少个奇数，value代表的是含有key个奇数的区间的个数3
        int[] map = new int[n + 1];
        map[0] = 1;
        int oddCount = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            oddCount += nums[i] & 1;
            if (oddCount - k >= 0) cnt += map[oddCount - k];
            map[oddCount]++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1, 1};
        int k = 2;
        int res = s.numberOfSubarrays(test, k);
        System.out.println(res);
    }
}
