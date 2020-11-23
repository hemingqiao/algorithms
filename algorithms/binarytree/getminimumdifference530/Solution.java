package blogandquestion.algorithms.binarytree.getminimumdifference530;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 13:49:03
 * description:
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 参考：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/di-gui-he-fei-di-gui-liang-chong-jie-fa-zui-hao-de/
 */
public class Solution {
    // 因为二叉搜索树的中序遍历结果是升序的，只需要在中序遍历的时候和前一个节点比较，保存最小的差值即可
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) {
            // 二叉树的中序遍历是升序的，所以root.val是一定大于prev.val的
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
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
