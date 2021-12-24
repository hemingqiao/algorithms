package blogandquestion.algorithms.binarytree.iscousins993;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/17 10:42:33
 * description:
 */
public class ExerciseSolution {
    List<Integer> depths = new ArrayList<>();
    List<TreeNode> parent = new ArrayList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, 0);
        dfs(root, null, y, 0);
        return depths.get(0).equals(depths.get(1)) && parent.get(0) != parent.get(1);
    }

    public void dfs(TreeNode root, TreeNode par, int target, int depth) {
        if (root == null) return;
        if (root.val == target) {
            depths.add(depth);
            parent.add(par);
            return;
        }
        dfs(root.left, root, target, depth + 1);
        dfs(root.right, root, target, depth + 1);
    }


    public boolean isCousins1(TreeNode root, int x, int y) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isX = false, isY = false;
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode temp = queue.poll();
                if (temp.val == x) isX = true;
                if (temp.val == y) isY = true;
                // 排除父节点相同的情况
                if (temp.left != null && temp.right != null) {
                    int left = temp.left.val, right = temp.right.val;
                    if ((left == x && right == y) || (left == y && right == x)) return false;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            if (isX && isY) return true;
            if (isX || isY) return false;
            isX = isY = false; // 重置isX和isY的值，也可以不重置
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(4);
        test.left.left = new TreeNode(3);
        test.left.right = new TreeNode(8);
        test.right.left = new TreeNode(6);
        test.right.right = new TreeNode(5);
        test.left.left.right = new TreeNode(7);
        ExerciseSolution es = new ExerciseSolution();
        boolean res = es.isCousins1(test, 5, 8);
        System.out.println(res);
    }
}
