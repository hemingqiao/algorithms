package src.backtrack.findsubsequences491;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/16 11:10:51
 * description: 官解，em，现在不是很明白
 * 参考
 * see: https://leetcode-cn.com/problems/increasing-subsequences/solution/di-zeng-zi-xu-lie-by-leetcode-solution/
 * see: https://leetcode-cn.com/problems/increasing-subsequences/solution/java-ji-hu-shuang-bai-jie-jue-di-zeng-zi-xu-lie-we/
 */
public class OfficialSolution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (nums == null) return res;
        dfs(res, path, Integer.MIN_VALUE, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int preValue, int curIdx, int[] nums) {
        if (curIdx >= nums.length) {
            if (path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 将当前元素加入，并递归的向后遍历，在进行回溯
        if (nums[curIdx] >= preValue) {
            path.add(nums[curIdx]);
            dfs(res,path, nums[curIdx], curIdx + 1, nums);
            path.remove(path.size() - 1);
        }

        // 不遍历重复元素
        if (nums[curIdx] != preValue) {
            dfs(res, path, preValue, curIdx + 1, nums); // 从下一个元素开始遍历
        }
    }
}
