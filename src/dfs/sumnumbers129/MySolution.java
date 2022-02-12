package src.dfs.sumnumbers129;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 18:22:45
 * description:
 */
public class MySolution {
    int res;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            res += add(path);
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    private int add(List<Integer> path) {
        int res = 0;
        for (int i = 0; i < path.size(); i++) {
            res = res * 10 + path.get(i);
        }
        return res;
    }
}
