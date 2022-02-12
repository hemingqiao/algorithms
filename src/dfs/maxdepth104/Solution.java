package src.dfs.maxdepth104;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/22 14:20:19
 * description: 使用深度优先搜索，后序遍历，依次获取根节点左右子树的最大深度。
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 *
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root) + 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = root.left == null ? 0 : maxDepth(root.left);
        int rightDepth = root.right == null ? 0 : maxDepth(root.right);
        return Math.max(leftDepth, rightDepth);
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
