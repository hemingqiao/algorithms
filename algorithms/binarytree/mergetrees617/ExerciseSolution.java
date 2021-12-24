package blogandquestion.algorithms.binarytree.mergetrees617;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/27 20:07:39
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
