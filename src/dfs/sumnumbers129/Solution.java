package src.dfs.sumnumbers129;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/30 08:35:39
 * description:
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/0-ms-jiao-ke-shu-ji-jie-da-by-liuzhaoce/
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int i) {
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) return temp;
        return dfs(root.left, temp) + dfs(root.right, temp);
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
