package blogandquestion.algorithms.binarytree.traversal;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 13:34:14
 * description:
 */
public class TreeNode {
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
