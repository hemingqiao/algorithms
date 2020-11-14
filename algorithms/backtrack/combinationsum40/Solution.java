package blogandquestion.algorithms.backtrack.combinationsum40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/14 11:17:55
 * description:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s/_1zPYk70NvHsdY8UWVGXmQ
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 对candidates数组进行排序，方便进行剪枝
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, used);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum, boolean[] used) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            //if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            if (i > startIndex && candidates[i] == candidates[i + 1]) continue;
            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i + 1, sum, used);
            used[i] = false;
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        Solution s = new Solution();
        System.out.println(s.combinationSum2(candidates, 8));
    }
}

/**
 * 不借助used数组来实现同一层去重，新的去重逻辑很巧妙
 * 参考：https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/225211
 */
class AnotherSolution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 对candidates数组进行排序，方便进行剪枝
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 去重的逻辑是同一层（树的同一层）不能出现同一个元素，但是树的不同层（树枝）上可以出现不同层的元素
            // 但是在树的每一层的第一个出现的元素需要保留，同一层第一个出现的元素的特征是i == startIndex
            // 而第二个出现的元素其索引i > startIndex，这时就需要跳过这个重复出现的元素
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
