package src.dfs.mindepth111;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 08:28:29
 * description:
 */
public class AnotherSolution {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return minDepth + 1;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
