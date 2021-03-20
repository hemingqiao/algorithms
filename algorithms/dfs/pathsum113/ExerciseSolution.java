package blogandquestion.algorithms.dfs.pathsum113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/20 11:27:05
 * description: 二刷
 */
public class ExerciseSolution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(list, new ArrayList<>(), root, sum);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> path, TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) list.add(new ArrayList<>(path));
            path.remove(path.size() - 1); // 回溯到上一层的状态
            return;
        }
        dfs(list, path, root.left, target - root.val);
        dfs(list, path, root.right, target - root.val);
        path.remove(path.size() - 1); // 回溯到上一层的状态
    }
}
