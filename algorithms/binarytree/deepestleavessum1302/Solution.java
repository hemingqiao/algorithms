package blogandquestion.algorithms.binarytree.deepestleavessum1302;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/07 13:35:48
 * description:
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *  
 *
 * 提示：
 *
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
 *
 */
public class Solution {
    int res;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        int depth = getDepth(root);
        dfs(root, depth - 1);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null && depth == 0) {
            res += root.val;
        }
        dfs(root.left, depth - 1);
        dfs(root.right, depth - 1);
    }

    /**
     * 获取二叉树的最大深度
     *
     * @param root 根节点
     * @return 二叉树的最大深度
     */
    private int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}


class AnotherSolution {
    int maxDepth = -1;
    int res;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            } else if (depth == maxDepth) {
                // 深度相同时才加上当前节点的值
                res += root.val;
            }
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
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
