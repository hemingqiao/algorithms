package src.dfs.binarytreepaths257;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/30 14:19:12
 * description: dfs加先序遍历。
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 *
 */
public class MySolution {
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }
        dfs(root.left, s + root.val + "->");
        dfs(root.right, s + root.val + "->");
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

/**
 * 对上面解法的优化，时间从10ms降低到2ms
 * 解题思路
 * see: https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-jie-jin-shuang-bai-b/
 */
class AnotherSolution {
    List<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String s) {
        if (root == null) return; // 如果是空树（空节点），直接返回
        s += String.valueOf(root.val); // 当前节点不为空，将当前节点加入到路径s中
        // 如果是叶子节点，路径已经完整
        if (root.left == null && root.right == null) {
            res.add(s);
        } else {
            s += "->"; // 否则路径还不完整，路径需要加上->，继续递归左右子树构建完整路径
            dfs(root.left, s);
            dfs(root.right, s);
        }
    }
}
