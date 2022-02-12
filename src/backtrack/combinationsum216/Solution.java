package src.backtrack.combinationsum216;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/13 22:11:35
 * description:
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 *
 * 参考
 * https://mp.weixin.qq.com/s/HX7WW6ixbFZJASkRnCTC3w
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(n, k, 0, 1, path, res);
        return res;
    }

    // targetSum是目标总和，sum是当前path内的元素总和，k是递归的深度
    private void backtracking(int targetSum, int k, int sum, int startIndex,
                              List<Integer> path, List<List<Integer>> res) {
        // 剪枝操作，如果path内的元素总和大于等于目标总和，直接返回
        if (sum > targetSum) {
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum) res.add(new ArrayList<>(path));
            // 如果递归深度已经到达k，但path内的元素总和不等于目标，直接返回
            return;
        }
        // 题目限定只含有1-9的正整数，所以for循环遍历到小于等于9
        for (int i = startIndex; i <= 9; i++) {
            sum += i; // 选择元素，并求和
            path.add(i);
            backtracking(targetSum, k, sum, i + 1, path, res); // 递归
            sum -= i; // 回溯
            path.remove(path.size() - 1); // 回溯
        }
    }
}

/**
 * 对上面的解法再进行优化，时间效率从击败65到击败100
 * 参考：https://leetcode-cn.com/problems/combination-sum-iii/solution/hui-su-he-hui-su-you-hua-yi-ji-di-gui-zui-hao-de-j/
 */
class AnotherSolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(n, k, 0, 1, path, res);
        return res;
    }

    // targetSum是目标总和，sum是当前path内的元素总和，k是递归的深度
    private void backtracking(int targetSum, int k, int sum, int startIndex,
                              List<Integer> path, List<List<Integer>> res) {
        // 剪枝操作，如果path内的元素总和大于等于目标总和，或者path的size等于k，就需要终止递归了
        if (path.size() == k || sum >= targetSum) {
            // 如果找到一组合适的，加入到list中
            if (path.size() == k && sum == targetSum) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // 题目限定只含有1-9的正整数，所以for循环遍历到小于等于9
        for (int i = startIndex; i <= 9; i++) {
            sum += i; // 选择元素，并求和
            path.add(i);
            backtracking(targetSum, k, sum, i + 1, path, res); // 递归
            sum -= i; // 回溯
            path.remove(path.size() - 1); // 回溯
        }
    }
}

class ThirdSolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, n, k, path, res, 1);
        return res;
    }

    private void dfs(int sum, int target, int k, List<Integer> path, List<List<Integer>> res, int startIndex) {
        if (path.size() == k) {
            if (sum == target) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            dfs(sum + i, target, k, path, res, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
