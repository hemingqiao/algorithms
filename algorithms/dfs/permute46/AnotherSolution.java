package blogandquestion.algorithms.dfs.permute46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/20 08:29:25
 * description: 太他妈难理解了。容我再想想。
 */
public class AnotherSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, res);
        return res;
    }

    private void backtracking(int[] nums, int level, List<List<Integer>> list) {
        if (level == nums.length - 1) {
            List<Integer> l = new ArrayList<>();
            for (int i : nums) {
                l.add(i);
            }
            list.add(l);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            backtracking(nums, level + 1, list);
            swap(nums, i, level);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        AnotherSolution as = new AnotherSolution();
        List<List<Integer>> res = as.permute(test);
        System.out.println(res);
    }
}
