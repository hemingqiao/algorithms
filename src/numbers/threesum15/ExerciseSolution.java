package src.numbers.threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/15 20:17:24
 * description:
 */
public class ExerciseSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int fixed = nums[i];
            if (fixed > 0) return ret; // 数组是升序排列的，所以如果nums[i] > 0，后面不可能出现和为0的解，直接返回
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过可能导致重复的解
            int left = i + 1, right = n - 1;
            while (left < right) {
                int temp = fixed + nums[left] + nums[right];
                if (temp > 0) {
                    right--;
                } else if (temp < 0) {
                    left++;
                } else {
                    List<Integer> t = new ArrayList<>();
                    t.add(fixed);
                    t.add(nums[left]);
                    t.add(nums[right]);
                    ret.add(t);
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return ret;
    }
}
