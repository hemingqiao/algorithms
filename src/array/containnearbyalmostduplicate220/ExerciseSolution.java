package src.array.containnearbyalmostduplicate220;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/17 13:11:41
 * description:
 */
public class ExerciseSolution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 10000) return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int fixed = nums[i];
            int start = Math.max(0, i - k);
            int end = Math.min(n - 1, i + k);
            for (int j = start; j <= end; j++) {
                if (j == i) continue;
                if (Math.abs((long) nums[j] - (long) fixed) <= t) return true;
            }
        }
        return false;
    }

    // 参考：https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            Long l = set.floor(u); // 从TreeSet中找到小于等于u的最大值
            Long h = set.ceiling(u); // 从TreeSet中找到大于等于u的最小值
            if (l != null && u - l <= t) return true;
            if (h != null && h - u <= t) return true;
            // 将当前值添加到TreeSet中，并移除掉范围不在[max(0, i - k), i)内的数
            set.add(u);
            if (i >= k) set.remove((long) nums[i - k]);
        }
        return false;
    }

    /*
    参考：https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/
     */

    long size;
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i];
            long idx = getIndex(u);
            if (map.containsKey(idx)) return true;
            long l = idx - 1, h = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(h) && map.get(h) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            if (i >= k) map.remove(getIndex(nums[i - k]));
        }
        return false;
    }

    public long getIndex(long index) {
        // 获取桶编号，使用index / cnt(桶的个数)，当index为-1时需要桶编号为0，所以 (index + 1) / cnt - 1
        return index >= 0 ? index / size : (index + 1) / size - 1;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{2,0,-2,2};
        boolean res = es.containsNearbyAlmostDuplicate2(test, 2, 1);
        System.out.println(res);
    }
}
