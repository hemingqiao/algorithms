package src.binarytree.flatten114;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/18 09:46:19
 * description: 使用一个辅助的节点pre，pre代表已经合并完成的单链表。
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 *
 * 解题思路
 * see: https://leetcode.wang/
 * see: https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
 */
public class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return; // base case
        // 将左右子树转化为单链表
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}

/**
 * 参考：https://github.com/grandyang/leetcode/issues/114
 */
class AnotherSolution {
    // 先找到最左的节点，将这个节点挂在其父节点的右子树上，而原先的右子节点挂在新的右子节点的右子树上
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left; // 将最左的节点的左子树挂在右子树上
        root.left = null; // 将最左的节点的左子树置为空
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp; // 将原先的右子节点挂在新的右子节点的右子树上
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
