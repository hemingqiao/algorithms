package blogandquestion.algorithms.backtrack.subsetswithdup90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/31 21:17:26
 * description:
 */
public class ExerciseSolution1 {
    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return new ArrayList<>();
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
            // for循环循环的是递归深度位于同一层的元素，递归进到backtrack里深度会加1
            // 所以这里可以保证是同一层的，如果同一层中nums[i] == nums[i - 1]，需要跳过重复
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(list, path, i + 1, nums);
            path.remove(path.cnt() - 1);
        }
    }*/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, path, 0, nums);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> path, int startIndex, int[] nums) {
        list.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // for循环循环的是递归深度位于同一层的元素，递归进到backtrack里深度会加1
            // 所以这里可以保证是同一层的，如果同一层中nums[i] == nums[i - 1]，需要跳过重复
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(list, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
