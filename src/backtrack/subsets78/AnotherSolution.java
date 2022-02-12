package src.backtrack.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/13 20:49:35
 * description:
 * 解题思路
 * see: https://leetcode-cn.com/problems/subsets/solution/hui-su-wei-yun-suan-di-gui-deng-gong-4chong-fang-s/
 */
public class AnotherSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex) {
        // 走过的所有路径都是子集的一部分，都需要加入到结果列表中
        // path是引用传递，所以这里需要new一个新的list
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]); // 做出选择
            backtracking(res,path,nums,i + 1); // 递归
            path.remove(path.size() - 1); // 撤销选择
        }
    }
}
