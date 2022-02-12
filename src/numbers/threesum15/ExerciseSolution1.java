package src.numbers.threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/24 11:16:01
 * description:
 */
public class ExerciseSolution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int fixed = nums[i];
            if (fixed > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int temp = fixed + nums[left] + nums[right];
                if (temp < 0) {
                    left++;
                } else if (temp > 0) {
                    right--;
                } else {
                    List<Integer> t = new ArrayList<>();
                    int l = nums[left], r = nums[right];
                    t.add(fixed);
                    t.add(l);
                    t.add(r);
                    list.add(t);
                    while (left < right && nums[right] == r) right--;
                    while (left < right && nums[left] == l) left++;
                }
            }
        }
        return list;
    }
}
