package src.binarytree.sumofleftleaves404;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/29 08:34:44
 * description:
 * 解题思路
 * see: https://leetcode-cn.com/problems/sum-of-left-leaves/solution/404zuo-xie-zi-zhi-he-liang-chong-xie-fa-dfshe-bfs-/
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 *
 */
public class MySolution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            if (isLeft) return root.val;
            return 0;
        }
        return dfs(root.left, true) + dfs(root.right, false);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
