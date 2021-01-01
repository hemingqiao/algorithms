package blogandquestion.algorithms.array.findrelativeranks506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 16:13:32
 * description:
 * 参考：https://leetcode-cn.com/problems/relative-ranks/solution/pai-xu-jia-mapshi-jian-ji-bai-83kong-jia-z3w4/
 */
public class AnotherSolution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            if (i < n - 3) {
                ret[map.get(nums[i])] = String.valueOf(n - i);
            } else if (i == n - 3) {
                ret[map.get(nums[i])] = "Bronze Medal";
            } else if (i == n - 2) {
                ret[map.get(nums[i])] = "Silver Medal";
            } else {
                ret[map.get(nums[i])] = "Gold Medal";
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        AnotherSolution s = new AnotherSolution();
        int[] test = new int[]{4, 5, 3, 2, 1};
        String[] res = s.findRelativeRanks(test);
        System.out.println(Arrays.toString(res));
    }
}
