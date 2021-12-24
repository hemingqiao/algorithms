package blogandquestion.algorithms.binarytree.lcof28;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 13:56:03
 * description:
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // 递归结束的条件是：两个节点都为空，其中一个节点为空，或者两个节点的值不等
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        // 因为要判断整个树是否为镜像对称，所以需要递归的比较左节点的左子树和右节点的右子树，左节点的右子树和右节点的左子树
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
