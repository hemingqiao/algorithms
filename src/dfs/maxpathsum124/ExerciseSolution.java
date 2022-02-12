package src.dfs.maxpathsum124;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/05 13:41:54
 * description:
 */
public class ExerciseSolution {
    int max = Integer.MIN_VALUE;
    // 树就是使用递归定义的，求解树的题目时，优先考虑递归解法
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSumSide(root);
        return max;
    }

    // 求解以root为根节点的单侧最大路径和
    // 求解最大的路径和可以分解为左子节点的最大路径和加上右子节点的最大路径和加上当前结点的值
    public int maxPathSumSide(TreeNode root) {
        if (root == null) return 0;
        // 题目给出的数据中，值可能为负，负的节点对最大路径是没有贡献的，需要排除
        int leftSum = Math.max(maxPathSumSide(root.left), 0);
        int rightSum = Math.max(maxPathSumSide(root.right), 0);
        max = Math.max(max, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val; // 返回以root为根节点的单侧最大路径和
    }
}
