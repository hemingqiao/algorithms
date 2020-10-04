package blogandquestion.algorithms.twosum1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/03 16:32:56
 * description:
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!temp.containsKey(nums[i])) {
                temp.put(target - nums[i], i);
            } else {
                return new int[]{temp.get(nums[i]), i};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new Solution().twoSum(test, 9)));
    }
}
