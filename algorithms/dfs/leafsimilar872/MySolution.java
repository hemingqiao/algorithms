package blogandquestion.algorithms.dfs.leafsimilar872;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/28 18:28:25
 * description: 深度优先遍历。
 */
public class MySolution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        dfs(root1, res1);
        dfs(root2, res2);
        return res1.equals(res2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) { // 叶子节点，把节点的值加入list
            list.add(root.val);
        }
        dfs(root.left, list);
        dfs(root.right, list);
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
