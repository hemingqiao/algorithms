package src.backtrack.subsetswithdup90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/05 21:20:25
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, path, used, 0, nums);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> path, boolean[] used, int startIndex, int[] nums) {
        if (startIndex == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        list.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(list, path, used, i + 1, nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
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
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(list, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
