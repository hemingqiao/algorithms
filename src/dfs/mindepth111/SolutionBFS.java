package src.dfs.mindepth111;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/14 11:55:27
 * description:
 */
public class SolutionBFS {
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

    // 利用层序遍历求解
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
