package src.backtrack.combinationsum39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/04 20:47:10
 * description:
 */
public class ExerciseSolution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, path, candidates, target, 0, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> path,
                          int[] nums, int target, int cur, int startIndex) {
        if (cur >= target) {
            if (cur == target) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(list, path, nums, target, cur + nums[i], i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        ExerciseSolution2 es = new ExerciseSolution2();
        int[] test = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> res = es.combinationSum(test, target);
        System.out.println(res);
    }
}
