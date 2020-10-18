package blogandquestion.algorithms.binarytree.flatten114;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/18 09:46:19
 * description: 使用一个辅助的节点pre，pre代表已经合并完成的单链表。
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 *
 * 解题思路
 * see: https://leetcode.wang/
 * see: https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
 */
public class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return; // base case
        // 将左右子树转化为单链表
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
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
