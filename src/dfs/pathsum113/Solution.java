package src.dfs.pathsum113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/24 09:10:12
 * description: 这里没有使用回溯，而是在每个分支处新建一个list避免分支污染。
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/path-sum-ii/solution/3chong-fang-shi-jie-jue-2chong-ji-bai-liao-100de-2/
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) return;
        // 因为list是引用传递，为了防止递归时分支污染，在每个路径中都新建一个list
        List<Integer> temp = new ArrayList<>(list);
        temp.add(root.val);
        if (root.left == null && root.right == null) { // 到达叶子节点
            if (sum == root.val) res.add(temp); // 到达叶子节点时，如果sum值和root.val值相等，说明找到一条路径
            return;
        }
        // 这里sum值要减去节点的值
        dfs(root.left, sum - root.val, temp, res);
        dfs(root.right, sum - root.val, temp, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
