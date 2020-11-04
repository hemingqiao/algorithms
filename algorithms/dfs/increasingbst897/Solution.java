package blogandquestion.algorithms.dfs.increasingbst897;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/04 21:47:31
 * description: 利用dfs，以中序遍历的方式取出树的节点值，然后按顺序构造新的树。
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 *
 */
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        TreeNode newRoot = new TreeNode(res.get(0));
        TreeNode temp = newRoot;
        int i = 1;
        while (i < res.size()) {
            temp.right = new TreeNode(res.get(i++));
            temp = temp.right;
        }
        return newRoot;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
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
