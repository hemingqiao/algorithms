package src.dfs.maxdepth104;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/06 17:23:06
 * description:
 */
public class OnelineSolution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
