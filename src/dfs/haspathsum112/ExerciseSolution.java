package src.dfs.haspathsum112;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/20 11:08:58
 * description: 二刷
 */
public class ExerciseSolution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode root, int target) {
        // root为空时，不存在这样的路径，尤其是当递归深度为0即刚调用dfs函数时，传入的节点为空，此时应该直接返回false
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == target) return true;
        return dfs(root.left, target - root.val) || dfs(root.right, target - root.val);
    }
}
