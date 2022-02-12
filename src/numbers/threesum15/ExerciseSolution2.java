package src.numbers.threesum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/23 22:25:25
 * description:
 */
public class ExerciseSolution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1, k = n - 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 从大到小查找满足 nums[i] + nums[j] + nums[k] >= 0 的下一个k值，所以是从k - 1开始查找
                // 一直找到最左边满足大于等于0的k，也同时对k进行了去重
                while (j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= 0) k--;
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[k]);
                    list.add(t);
                }
            }
        }
        return list;
    }
}
