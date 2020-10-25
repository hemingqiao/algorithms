package blogandquestion.algorithms.dfs.issymmetric101;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 19:48:40
 * description: 递归解法。
 * 解题思路
 * see: https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 *
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // 也是迷，测试用例中root为null要返回true
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

    TreeNode(int x) {
        val = x;
    }
}
