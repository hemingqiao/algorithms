package blogandquestion.algorithms.array.prefixsum.numsubarraywithsum930;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/08 20:48:12
 * description:
 */
public class ExerciseSolution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        // 以i结尾的子数组的和可以表示为 s[i] - s[j]
        // 所有以i结尾的子数组可以表示为：s[i] - s[0], s[i] - s[1] ... s[i] - s[i - 1]
        // 也就是找到 s[i] - s[j] == goal 的个数，即s[j] = s[i] - goal的个数, 0 <= j <= i - 1
        for (int i = 0; i <= n; i++) {
            int a = s[i] - goal;
            res += cnt.getOrDefault(a, 0);
            cnt.put(s[i], cnt.getOrDefault(s[i], 0) + 1);
        }
        return res;
    }

    public int numSubarrayWithSum1(int[] nums, int goal) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        // 前缀和数组中 s[0] = 0, s[1] = s[0] + nums[0]
        // 而cnt记录的是某个前缀和出现的次数，也就是将s数组中的每个值映射到哈希表中，所以0已经出现了一次，遍历从1开始
        cnt.put(0, 1);
        for (int i = 1, s = 0; i <= n; i++) {
            s += nums[i - 1];
            res += cnt.getOrDefault(s - goal, 0);
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        return res;
    }
}
