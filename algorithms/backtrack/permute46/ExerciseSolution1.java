package blogandquestion.algorithms.backtrack.permute46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/07 21:43:20
 * description:
 */
public class ExerciseSolution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(list, path, nums, used);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtracking(list, path, nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
