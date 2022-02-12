package src.backtrack.combinationsum39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/14 10:44:18
 * description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 *
 * 参考
 * https://mp.weixin.qq.com/s/FLg8G6EjVcxBjwCbzpACPw
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, candidates, target, 0, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path,
                              int[] candidates, int target, int sum, int startIndex) {
        if (sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            // 题目限定数字可以被重复选取，所以索引startIndex不需要加1，而是仍从i开始
            backtracking(res, path, candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum(candidates, 7);
        System.out.println(res);
    }
}

/**
 * 对上面的解法进行优化，添加了剪枝操作
 */
class AnotherSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 对candidates数组进行排序，方便进行剪枝
        Arrays.sort(candidates);
        backtracking(res, path, candidates, target, 0, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path,
                              int[] candidates, int target, int sum, int startIndex) {
        if (sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 进行剪枝，如果当前sum加上i处的元素值之和小于等于target，才进入循环，前提是candidates数组需要有序（升序）
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            // 题目限定数字可以被重复选取，所以索引startIndex不需要加1，而是仍从i开始
            backtracking(res, path, candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
