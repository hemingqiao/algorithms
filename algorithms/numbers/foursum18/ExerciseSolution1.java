package blogandquestion.algorithms.numbers.foursum18;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/26 20:09:22
 * description:
 */
public class ExerciseSolution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return list;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1, m = n - 1; k < m; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] + nums[k + 1] > target) break; // 剪枝，如果循环内的最小的四个值已经大于target了，直接退出循环
                    while (k < m - 1 && nums[i] + nums[j] + nums[k] + nums[m - 1] >= target) m--;
                    if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[m]);
                        list.add(t);
                    }
                }
            }
        }
        return list;
    }
}
