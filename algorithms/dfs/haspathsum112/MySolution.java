package blogandquestion.algorithms.dfs.haspathsum112;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/24 09:37:42
 * description: 解题思路参考了113的解法。
 */
public class MySolution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        List<Boolean> list = new ArrayList<>(); // 维护一个类型为布尔值的list
        dfs(root, sum, list);
        if (!list.isEmpty()) return list.get(0);
        return false;
    }

    private void dfs(TreeNode root, int sum, List<Boolean> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) { // 只关心根节点到叶子节点的路径，其余的路径直接进入下一层递归
            if (root.val == sum) {
                list.add(true);
                return;
            }
        }
        dfs(root.left, sum - root.val, list);
        dfs(root.right, sum - root.val, list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
