package blogandquestion.algorithms.dfs.maxdepth104;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/22 15:24:25
 * description: 二叉树的层序遍历。执行速度只能击败2%，有点慢。
 */
public class AnotherSolution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head.left != null) queue.add(head.left);
                if (head.right != null) queue.add(head.right);
            }
        }
        return depth;
    }
}
