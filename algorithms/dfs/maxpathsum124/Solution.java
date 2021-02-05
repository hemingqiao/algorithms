package blogandquestion.algorithms.dfs.maxpathsum124;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/19 21:37:51
 * description: 利用深度优先搜索，在搜索过程中更新max。
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例 2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 *
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/java-1zhao-zou-tian-xia-by-sweetiee/
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // dfs返回一个节点的一侧的最大值，如果左子树的最大路径值大于右子树的最大路径值
    // dfs返回左子树最大路径之和与root的值之和
    // 简而言之，dfs函数返回的是root节点以下所包含路径的最大值
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(0, dfs(root.left)); // 如果结果为负数的话，需要舍弃
        int rightSum = Math.max(0, dfs(root.right));
        max = Math.max(max, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
