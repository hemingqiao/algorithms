package blogandquestion.algorithms.backtrack.getpermutation60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 16:06:18
 * description:
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 3
 * 输出："213"
 * 示例 2：
 *
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 示例 3：
 *
 * 输入：n = 3, k = 1
 * 输出："123"
 *  
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 *
 */
public class Solution {
    // 利用回溯找到前k个排列，返回第k个排列
    // 但是效率感人，但是直接找全部的排列会超时😂
    public String getPermutation(int n, int k) {
        List<List<Integer>> res = permute(n, k);
        StringBuilder sb = new StringBuilder();
        List<Integer> r = res.get(k - 1);
        for (int i : r) {
            sb.append(i);
        }
        return sb.toString();
    }

    private List<List<Integer>> permute(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtracking(res, path, n, used, k);
        return res;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> path, int n, boolean[] used, int k) {
        if (path.size() == n) {
            list.add(new ArrayList<>(path));
            return;
        }
        // 在回溯到第k个排列之后停止
        if (list.size() == k) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                path.add(i + 1);
                used[i] = true;
                backtracking(list, path, n, used, k);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 3));
    }
}
