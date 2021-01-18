package blogandquestion.algorithms.array.findshortestsubarray697;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/18 19:52:24
 * description:
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
