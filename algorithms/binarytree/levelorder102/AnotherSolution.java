package blogandquestion.algorithms.binarytree.levelorder102;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 21:00:39
 * description:
 */
public class AnotherSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    // depth记录了树的深度，通过使用depth将同一层元素加到同一个list中
    private void dfs(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        } else {
            res.get(depth).add(root.val);
        }

        // 这个地方隐藏有回溯
        dfs(res, root.left, depth + 1);
        dfs(res, root.right, depth + 1);
    }
}
