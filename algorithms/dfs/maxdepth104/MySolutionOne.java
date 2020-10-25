package blogandquestion.algorithms.dfs.maxdepth104;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 08:56:28
 * description: 时间击败100，空间击败97.7
 */
public class MySolutionOne {
    private int maxDepth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return maxDepth + 1; // dfs比较的根节点以下的最大深度，树的最大深度还需要加上根节点的1
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        maxDepth = Math.max(maxDepth, depth);
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
