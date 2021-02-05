package blogandquestion.algorithms.backtrack.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/05 21:08:02
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(list, path, 0, nums);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> path, int startIndex, int[] nums) {
        if (startIndex == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        list.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(list, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
