package src.dfs.issametree100;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 19:26:54
 * description: 简直不要再简洁。
 * 解题思路
 * see: https://leetcode-cn.com/problems/same-tree/solution/xie-shu-suan-fa-de-tao-lu-kuang-jia-by-wei-lai-bu-/
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 *
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // p和q同时为null时返回true
        else if (p == null || q == null) return false; // p和q其中一个为null时返回false
        if (p.val != q.val) return false;
        // 两个数的根节点比较完之后
        // 递归比较两个数的左右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class AnotherSolution {
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
