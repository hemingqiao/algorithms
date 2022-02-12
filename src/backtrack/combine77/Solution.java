package src.backtrack.combine77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/13 21:38:49
 * description:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 *
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s/OnBjbLzuipWz_u4QfmgcqQ
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i); // 做出选择
            backtracking(n, k, i + 1); // 递归
            path.remove(path.size() - 1); // 撤销选择，回溯
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.combine(4, 3);
        System.out.println(res);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/combinations/solution/77-zu-he-hui-su-fa-jing-dian-ti-mu-by-carlsun-2/
 */
class AnotherSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(res, path, n, k, 1);
        return res;
    }

    // 剪枝优化
    private void backtracking(List<List<Integer>> res, List<Integer> path,
                              int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 如果for循环选择的起始位置之后的元素个数 已经不足 需要的元素个数了，那么就没有必要继续搜索下去了
        // 已经选择的元素个数：path.cnt()
        // 还需要的元素个数：k - path.cnt()，因此在集合n中至少要从n - (k - path.cnt()) + 1开始遍历才有意义
        // 为什么要加1，因为遍历起始索引startIndex是从1开始的，而不是从0开始的，此时元素的值就等于索引的值
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(res, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new AnotherSolution().combine(4, 2));
    }
}
