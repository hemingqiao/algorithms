package src.graph.distancek863;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/28 21:21:34
 * description:
 */
public class Solution {
    List<Integer> ans = new ArrayList<>();
    Map<TreeNode, List<TreeNode>> g = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs1(root);
        dfs2(target, null, K);
        return ans;
    }

    public void dfs1(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (!g.containsKey(root)) g.put(root, new ArrayList<>());
            g.get(root).add(root.left);
            if (!g.containsKey(root.left)) g.put(root.left, new ArrayList<>());
            g.get(root.left).add(root);
            dfs1(root.left);
        }
        if (root.right != null) {
            if (!g.containsKey(root)) g.put(root, new ArrayList<>());
            g.get(root).add(root.right);
            if (!g.containsKey(root.right)) g.put(root.right, new ArrayList<>());
            g.get(root.right).add(root);
            dfs1(root.right);
        }
    }

    public void dfs2(TreeNode root, TreeNode father, int k) {
        if (k == 0) ans.add(root.val);
        else {
            for (TreeNode son : g.getOrDefault(root, new ArrayList<>())) {
                if (son != father) dfs2(son, root, k - 1);
            }
        }
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
