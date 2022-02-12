package src.binarytree.rangesumbst938;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 08:43:18
 * description:
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 *
 */
public class Solution {
    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        dfs(root, low, high);
        return res;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) return;
        dfs(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        dfs(root.right, low, high);
    }
}

class AnotherSolution {
    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        dfs(root, low, high);
        return res;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) return;
        // 二叉搜索树在某种程度上是有序的
        if (root.val >= low && root.val <= high) {
            res += root.val;
            dfs(root.left, low, high);
            dfs(root.right, low, high);
        } else if (root.val < low) {
            // 如果当前节点的值小于low，满足条件的节点值只会在当前节点的右边
            // 左边便可以舍弃
            dfs(root.right, low, high);
        } else {
            dfs(root.left, low, high);
        }
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
