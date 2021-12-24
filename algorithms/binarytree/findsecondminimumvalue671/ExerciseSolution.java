package blogandquestion.algorithms.binarytree.findsecondminimumvalue671;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/27 22:53:00
 * description:
 */
public class ExerciseSolution {
    long d1 = Long.MAX_VALUE, d2 = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root == null) return;
        int x = root.val;
        if (x < d1) {
            d2 = d1;
            d1 = x;
        } else if (x < d2 && x > d1) {
            d2 = x;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (d2 == Long.MAX_VALUE) return -1;
        return (int) d2;
    }

    int d11 = 0;
    long d22 = Long.MAX_VALUE;

    public int findSecondMinimumValue1(TreeNode root) {
        d1 = root.val;
        dfs1(root);
        return d22 == Long.MAX_VALUE ? -1 : (int) d22;
    }

    public void dfs1(TreeNode root) {
        if (root == null) return;
        // 因为是从上至下递归，如果节点的值不等于最小值，一定是大于最小值的
        if (root.val != d11 && root.val < d22) d22 = root.val;
        dfs1(root.left);
        dfs1(root.right);
    }
}
