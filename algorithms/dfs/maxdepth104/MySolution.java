package blogandquestion.algorithms.dfs.maxdepth104;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 08:53:45
 * description:
 */
public class MySolution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int m1 = maxDepth(root.left);
        int m2 = maxDepth(root.right);
        if (root.left == null || root.right == null) return m1 + m2 + 1;
        return Math.max(m1, m2) + 1;
    }
}
