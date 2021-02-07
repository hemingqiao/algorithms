package blogandquestion.algorithms.dfs.zigzaglevelorder103;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/07 19:37:22
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean dir = true; // dir为true表示遍历方向从左到右，反之从右到左
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            if (dir){
                list.add(temp);
            } else {
                Collections.reverse(temp);
                list.add(temp);
            }
            dir = !dir;
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(list, root, 0);
        return list;
    }

    public void dfs(List<List<Integer>> list, TreeNode root, int depth) {
        if (root == null) return;
        // 第一次递归进来时，depth == list.size()，此时直接向list中加入一个数组
        if (depth == list.size()) {
            List<Integer> t = new ArrayList<>();
            t.add(root.val);
            list.add(t);
        } else {
            // 否则，根据所处的层是奇数还是偶数向list中append
            if (depth % 2 == 1) {
                list.get(depth).add(0, root.val);
            } else {
                list.get(depth).add(root.val);
            }
        }
        dfs(list, root.left, depth + 1);
        dfs(list, root.right, depth + 1);
    }
}
