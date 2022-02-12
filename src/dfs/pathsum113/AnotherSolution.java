package src.dfs.pathsum113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/24 09:29:09
 * description: 使用回溯
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/path-sum-ii/solution/3chong-fang-shi-jie-jue-2chong-ji-bai-liao-100de-2/
 */
public class AnotherSolution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) { // 如果是叶子节点
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1); // 移除此次添加进list的节点值，回溯到上一节点
            return;
        }
        dfs(root.left, sum - root.val, list, res);
        dfs(root.right, sum - root.val, list, res);
        list.remove(list.size() - 1); // 移除此次添加进list的节点值，方便回溯
    }
}
