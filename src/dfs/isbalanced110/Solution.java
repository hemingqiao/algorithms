package src.dfs.isbalanced110;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/22 08:24:59
 * description: 利用深度优先搜索加回溯。看了那么多同类型的终于能够写出来一个了。
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 
 */
public class Solution {
    private boolean state = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; // root为null返回true
        dfs(root);
        return state;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftLength = root.left == null ? 0 : dfs(root.left) + 1;
        int rightLength = root.right == null ? 0 : dfs(root.right) + 1;
        // 如果任意一个节点对应的子树不是高度平衡的，将state置为false
        if (Math.abs(leftLength - rightLength) > 1) state = false;
        return Math.max(leftLength, rightLength);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
