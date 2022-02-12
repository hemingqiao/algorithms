package src.dfs.longestunivaluepath687;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/19 22:11:25
 * description: 还是利用深度优先搜索，同时更新辅助变量max。
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/longest-univalue-path/solution/guan-yu-di-gui-si-lu-de-chao-xiang-xi-ge-ren-jian-/
 */
public class Solution {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestPath(root);
        return ans;
    }

    // 递归函数功能：搜寻以node为起点的最长同值路径:要么是以node为起点的左子树，要么是以node为起点的右子树
    // 同时在搜索过程中更新辅助变量max的值
    // 返回以node为根节点的具有相同值的最长路径值
    public int longestPath(TreeNode node) {
        if (node == null) return 0;
        int maxLength = 0;
        int left = longestPath(node.left); // node左子树的最长同值路径
        int right = longestPath(node.right);// node右子树的最长同值路径
        // 这种情况对于寻找最长同值路径长有帮助，对于搜索以root为路径起始点的最长路径没有帮助
        // 下面代码处理的是左子树、root、右子树同值，这时可以与max做一次比较，但是就像上面所说的，对于搜索以root为路径起始点的最长路径没有帮助
        if (node.left != null && node.left.val == node.val && node.right != null && node.right.val == node.val) {
            ans = Math.max(ans, left + right + 2);
        }
        // 从左右子树中选择最长的同值路径
        if (node.left != null && node.left.val == node.val) {
            maxLength = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            maxLength = Math.max(maxLength, right + 1);
        }
        // 从ans与maxLorRres中更新最大值
        ans = Math.max(ans, maxLength);
        return maxLength; // 返回以node为起点的最长同值路径
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
