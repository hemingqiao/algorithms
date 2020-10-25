package blogandquestion.algorithms.dfs.isvalidbst98;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 09:06:49
 * description:
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s/B9zmMQDCSWanjHCCwUSAuA
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE); // 给出的测试用例的节点值可能超过Integer的范围
    }

    private boolean dfs(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        // 如果节点超过这个范围，返回false
        // 注意包含等于，因为左子树或右子树的节点值等于根节点的值也是不允许的
        if (root.val >= maxVal || root.val <= minVal) return false;
        // 左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的节点的值要比当前节点的值小
        // 右子树范围的最小值是当前节点的值，也就是root的值，最大值是maxVal，因为右子树的节点的值要比当前节点的值大
        return dfs(root.left, minVal, root.val) && dfs(root.right, root.val, maxVal);
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

