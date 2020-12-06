package blogandquestion.algorithms.binarytree.deletenode450;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 16:09:02
 * description:
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 *
 * 参考：https://github.com/grandyang/leetcode/issues/450
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                root = root.left == null ? root.right : root.left;
            } else {
                // 如果进入这个分支，表明root左子树和右子树均不为空
                // 则需要找到右子树的最小值，将这个最小值作为新的根，并将其从原位置删除
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                root.val = cur.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
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
