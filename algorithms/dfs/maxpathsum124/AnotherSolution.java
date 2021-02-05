package blogandquestion.algorithms.dfs.maxpathsum124;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/19 21:57:39
 * description: 这个的注释感觉更好一些
 * see: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/453749
 */
public class AnotherSolution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // dfs返回以root为根节点的单侧最大路径和
    public int dfs(TreeNode root) {
        // 返回当前子树的最大值
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 当前节点为n,对于当前节点来说，最大值可以为n+left,n+right,n,n+left+right
        // 上面四项中的一个，但是返回值是不能返回第四个的，那种路径是不成立的，但是需要比较这条路径的值和最大值
        // 因为存在这条路径的值是最大值的可能，下面代码中的p2即是执行此操作
        int p = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, p);
        int p2 = Math.max(p, root.val + left + right);
        max = Math.max(max, p2);
        return p;
    }
}
