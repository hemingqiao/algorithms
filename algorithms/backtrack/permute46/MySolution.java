package blogandquestion.algorithms.backtrack.permute46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/16 19:39:32
 * description:
 * 参考：https://mp.weixin.qq.com/s/SCOjeMX1t41wcvJq49GhMw
 */
public class MySolution {
    // 这个的执行时间比下面（algorithm essential中的快上1ms，22%）
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(res, path, nums, used);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
        // 如果path中元素个数满足要求，则放入结果列表
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtracking(res, path, nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}

class AlgorithmEssential {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i : nums) {
            if (!path.contains(i)) {
                path.add(i);
                backtracking(res, path, nums);
                path.remove(path.size() - 1);
            }
        }
    }
}
