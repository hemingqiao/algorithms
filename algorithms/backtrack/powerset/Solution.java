package blogandquestion.algorithms.backtrack.powerset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 13:49:40
 * description:
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums, 0);
        return res;
    }

    // 增量构造法
    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 跳过当前元素
        backtracking(res, path, nums, startIndex + 1);

        // 选择当前元素
        path.add(nums[startIndex]);
        backtracking(res, path, nums, startIndex + 1);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 2, 3};
        List<List<Integer>> res = s.subsets(test);
        System.out.println(res);
    }
}
