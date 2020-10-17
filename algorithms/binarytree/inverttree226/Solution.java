package blogandquestion.algorithms.binarytree.inverttree226;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/17 16:48:25
 * description: 先序遍历翻转二叉树
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
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
