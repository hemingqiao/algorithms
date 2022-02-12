package src.dfs.findbottomleftvalue513;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/24 10:12:49
 * description: 层序遍历，记录一下每一层第一个节点的值。
 */
public class SolutionBFS {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) result = temp.val; // 记录下每一层的第一个节点的值
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return result;
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
