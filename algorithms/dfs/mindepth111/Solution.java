package blogandquestion.algorithms.dfs.mindepth111;

import java.util.ArrayDeque;
import java.util.Queue;

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

class AnotherSolution {
    public int minDepth(TreeNode root) {
        // 如果当前节点为空，直接返回0
        if (root == null) return 0;
        // 如果左子节点为空，对右子节点调用递归函数，加上当前节点的深度（1）返回
        if (root.left == null) return 1 + minDepth(root.right);
        // 如果右子节点为空，对左子节点调用递归函数，加上当前节点的深度（1）返回
        if (root.right == null) return 1 + minDepth(root.left);
        // 左右子节点都不为空，返回左右子树深度较小值加上当前节点深度
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                if (temp.left == null && temp.right == null) {
                    // 当某一层出现了叶子节点，该层的深度就是最小深度
                    return depth;
                }
            }
        }
        return depth;
    }
}
