package blogandquestion.algorithms.dfs.mindepth111;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 08:36:25
 * description: 使用DFS递归。
 * 解题思路
 * see: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        // root.left和root.right其中有一个为空时，m1和m2必有一个为0，可以直接相加
        if (root.left == null || root.right == null) return m1 + m2 + 1;
        return Math.min(m1, m2) + 1;
    }
}
