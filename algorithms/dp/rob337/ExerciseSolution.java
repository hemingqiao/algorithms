package blogandquestion.algorithms.dp.rob337;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/20 20:49:39
 * description:
 * 二刷，这题也是有意思
 */
public class ExerciseSolution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = help(root);
        return Math.max(res[0], res[1]);
    }

    public int[] help(TreeNode root) {
        // 对于每个结点，都存在偷与不偷两种状态，使用一个大小为2的数组分别标识这两种状态对应的金额
        // status[0]代表不偷根节点root，status[1]代表偷根节点root
        if (root == null) return new int[2];
        int[] status = new int[2];
        int[] left = help(root.left);
        int[] right = help(root.right);
        // 因为是求解能够偷到的最大值，所以当前结点不偷的话，能够偷到的最大值是左右子结点能够偷到的最大值之和
        status[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 如果当前结点偷了，因为不能连着偷，所以能够偷到的最大值是左右子结点都不偷之和加上当前结点的值
        status[1] = left[0] + right[0] + root.val;
        return status;
    }
}
