package blogandquestion.algorithms.binarytree.inverttree226;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/17 16:07:52
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 递归解法
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    // BFS解法
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return root;
    }
}
