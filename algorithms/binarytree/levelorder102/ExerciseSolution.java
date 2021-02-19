package blogandquestion.algorithms.binarytree.levelorder102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/19 19:40:50
 * description:
 */
public class ExerciseSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(list, root, 0);
        return list;
    }

    // 深度优先搜索
    public void dfs(List<List<Integer>> list, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == list.size()) {
            List<Integer> t = new ArrayList<>();
            t.add(root.val);
            list.add(t);
        } else {
            list.get(depth).add(root.val);
        }
        dfs(list, root.left, depth + 1);
        dfs(list, root.right, depth + 1);
    }

    // 广度优先搜索求解
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                t.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            list.add(t);
        }
        return list;
    }
}
