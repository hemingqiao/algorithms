package blogandquestion.algorithms.binarytree.levelorderbottom107;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/27 09:15:35
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>(); // 链表插入快
        if (root == null) return list;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                l.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            // 每次都插入到头部，就实现了翻转
            list.add(0, l);
        }
        return list;
    }

    // recursive solution
    public List<List<Integer>> levelOrderBotto1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(list, root, 0);
        Collections.reverse(list);
        return list;
    }

    public void dfs(List<List<Integer>> list, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == list.size()) list.add(new ArrayList<>());
        list.get(depth).add(root.val);
        dfs(list, root.left, depth + 1);
        dfs(list, root.right, depth + 1);
    }
}
