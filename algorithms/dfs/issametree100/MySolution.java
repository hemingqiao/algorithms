package blogandquestion.algorithms.dfs.issametree100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 19:12:53
 * description: 我写的这个太复杂了。但是时间效率居然还行，一头雾水。
 */
public class MySolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        dfs(p, res1);
        dfs(q, res2);
        if (res1.size() != res2.size()) return false;
        for (int i = 0; i < res1.size(); i++) {
            if (!res1.get(i).equals(res2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(-1); // 如果两个树完全一样，那么当遍历顺序都是中序时，在遍历到叶子节点时添加-1，两个树也是相同的。如果一个树中有节点为null，就记录下来
            return;
        }
        list.add(root.val);
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
