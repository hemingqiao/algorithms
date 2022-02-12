package src.backtrack.permute46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/24 09:38:13
 * description:
 * 参考：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
 */
public class ExerciseSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, nums.length);
        return res;
    }

    public void backtrack(List<List<Integer>> list, int[] nums, int depth, int n) {
        if (depth == n - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            list.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(nums, depth, i);
            backtrack(list, nums, depth + 1, n);
            swap(nums, depth, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
