package blogandquestion.algorithms.dfs.pathsum113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 21:51:45
 * description:
 */
public class SolutionDFS {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int target) {
        if (root == null) return; // 如果root为空，也就谈不上有左右子结点了
        path.add(root.val);
        // 到达叶子节点
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1); // 撤销此次的选择，进行回溯
            return;
        }
        dfs(res, path, root.left, target - root.val);
        dfs(res, path, root.right, target - root.val);
        path.remove(path.size() - 1); // 撤销选择，进行回溯
    }
}
