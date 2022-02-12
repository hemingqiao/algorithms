package src.binarytree.sumofleftleaves404;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/29 08:54:39
 * description: 关键在于如何判断节点为左叶子节点
 * 解题思路
 * see: https://leetcode-cn.com/problems/sum-of-left-leaves/solution/404-zuo-xie-zi-zhi-he-di-gui-yu-fei-di-gui-fang-fa/
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int midValue = 0;
        // 根据一个节点的父结点来判断这个节点是否是左叶子节点
        // 父节点的左子节点不为null，且左子节点的左子节点和右子节点均为null，则父节点的子节点为左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        return sumOfLeftLeaves(root.left) + midValue + sumOfLeftLeaves(root.right);
    }
}

class ThirdSolution {
    private int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return res;
    }
}

class AnotherSolution {
    private int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
