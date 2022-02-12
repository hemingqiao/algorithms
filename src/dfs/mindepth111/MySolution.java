package src.dfs.mindepth111;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 08:19:49
 * description:
 */
public class MySolution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        List<Integer> res = new ArrayList<>();
        res.add(Integer.MAX_VALUE);
        int depth = 0;
        dfs(root, 0, res);
        return res.get(0) + 1;
    }

    private void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.set(0, Math.min(list.get(0), depth)); // 只有到达叶子节点时，才与list中的值比较
        }
        depth++;
        dfs(root.left, depth, list);
        dfs(root.right, depth, list);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
