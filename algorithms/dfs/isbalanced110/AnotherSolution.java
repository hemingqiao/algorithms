package blogandquestion.algorithms.dfs.isbalanced110;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 20:26:54
 * description:
 */
public class AnotherSolution {
    // 重复计算太多
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) <= 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}


/**
 * 参考：https://github.com/grandyang/leetcode/issues/110
 */
class SolutionOpt {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    // 在进行深搜时，如果发现子树不平衡，直接返回-1，结束递归
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = dfs(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
