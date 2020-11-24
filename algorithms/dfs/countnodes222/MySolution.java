package blogandquestion.algorithms.dfs.countnodes222;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/27 11:17:07
 * description: 这题简单的超出想象（使用递归）。
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 *
 */
public class MySolution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
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

class AnotherSolution {
    public int countNodes(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        dfs(list, root, 0);
        int res = 0;
        for (List<TreeNode> l : list) {
            res += l.size();
        }
        return res;
    }

    private void dfs(List<List<TreeNode>> list, TreeNode root, int depth) {
        if (root == null) return;

        if (depth == list.size()) {
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            list.add(new ArrayList<>(path));
        } else {
            list.get(depth).add(root);
        }

        dfs(list, root.left, depth + 1);
        dfs(list, root.right, depth + 1);
    }
}
