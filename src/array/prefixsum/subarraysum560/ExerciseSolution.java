package src.array.prefixsum.subarraysum560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/16 16:18:32
 * description:
 */
public class ExerciseSolution {
    // 1、朴素解法，暴力循环
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) ret++;
            }
            sum = 0;
        }
        return ret;
    }

    // 前缀和+哈希表
    public int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 前缀和为0的数量是1
        int preSum = 0;
        int ret = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                ret += map.get(preSum - k); // 当前缀和为preSum - k时，恰好可以凑出和为k的连续子数组
            }
            // 下面的逻辑可以使用map的getOrDefault方法，但是会相对慢一些
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return ret;
    }
}
