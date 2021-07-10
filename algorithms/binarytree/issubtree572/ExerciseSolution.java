package blogandquestion.algorithms.binarytree.issubtree572;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/10 13:11:12
 * description:
 */
public class ExerciseSolution {
    // 树状哈希
    public static int P = 131, Q = 159, MOD = (int) (1e7 + 7);
    public int T = -1;
    public boolean ans = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        T = dfs(subRoot);
        if (T == dfs(root)) ans = true;
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 321024;
        int left = dfs(root.left), right = dfs(root.right);
        int x = root.val % MOD;
        if (left == T || right == T) ans = true;
        return (x + left * P + right * Q) % MOD;
    }
}
