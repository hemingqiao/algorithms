package src.backtrack.combinationsum39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/25 19:03:05
 * description:
 */
public class ExerciseSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(list, path, 0, target, 0, candidates, candidates.length);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> path,
                          int cur, int target, int startIndex, int[] nums, int n) {
        if (cur >= target) {
            if (cur == target) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < n; i++) {
            path.add(nums[i]);
            backtrack(list, path, cur + nums[i], target, i, nums, n);
            path.remove(path.size() - 1);
        }
    }
}

class ExerciseSolution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, path, 0, target, 0, candidates, candidates.length);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> path,
                          int cur, int target, int startIndex, int[] nums, int n) {
        if (cur >= target) {
            if (cur == target) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        // 在数组有序的前提下，进行剪枝
        for (int i = startIndex; i < n && cur + nums[i] <= target; i++) {
            path.add(nums[i]);
            backtrack(list, path, cur + nums[i], target, i, nums, n);
            path.remove(path.size() - 1);
        }
    }
}
