package blogandquestion.algorithms.backtrack.findsubsequences491;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/16 08:41:34
 * description:
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/increasing-subsequences/solution/jin-tian-wo-you-shuang-ruo-zhuo-neng-miao-dong-la-/
 * see: https://leetcode-cn.com/problems/increasing-subsequences/solution/you-ya-de-jian-xia-zhi-by-million-tian/
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, nums, -1);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int startIndex) {
        // 只要当前的递增序列大于1，就加入到结果列表中
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            // 注意这里没有加return，因为要取到树的同一个树枝上的所有节点
        }

        // 在 [startIndex + 1, nums.length - 1] 范围内遍历搜索递增序列的下一个值。
        // 借助 set 对 [startIndex + 1, nums.length - 1] 范围内的数去重。
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex + 1; i < nums.length; i++) {
            // 下面两句代码为去重逻辑
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);

            // 递归加回溯
            if (startIndex == -1 || nums[i] >= nums[startIndex]) {
                path.add(nums[i]);
                backtracking(res, path, nums, i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {4,3,2,1};
        Solution s = new Solution();
        List<List<Integer>> res = s.findSubsequences(test);
        System.out.println(res);
    }
}

class AnotherSolution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(res, path, nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, LinkedList<Integer> path, int[] nums, int startIndex) {
        if (path.size() > 1) {
            res.add(new LinkedList<>(path));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);

            // 需要先判断path是否为空，然后才能调用getLast方法，否则会抛出异常
            if (path.size() == 0 || path.getLast() <= nums[i]) {
                path.add(nums[i]);
                backtracking(res, path, nums, i + 1);
                path.removeLast();
            }
        }
    }
}
