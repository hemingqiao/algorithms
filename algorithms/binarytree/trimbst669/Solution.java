package blogandquestion.algorithms.binarytree.trimbst669;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/06 14:26:11
 * description:
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * 示例 1：
 *
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 *
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * 示例 3：
 *
 * 输入：root = [1], low = 1, high = 2
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,null,2], low = 1, high = 3
 * 输出：[1,null,2]
 * 示例 5：
 *
 * 输入：root = [1,null,2], low = 2, high = 4
 * 输出：[2]
 *  
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 104] 内
 * 0 <= Node.val <= 104
 * 树中每个节点的值都是唯一的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
 *
 * 参考：https://github.com/grandyang/leetcode/issues/669
 */
public class Solution {
    // 首先判断如果root为空，那么直接返回空即可。然后就是要看根结点是否在范围内，如果根结点值小于L，那么返回对其右子结点调用递归函数的值；
    // 如果根结点大于R，那么返回对其左子结点调用递归函数的值。如果根结点在范围内，将其左子结点更新为对其左子结点调用递归函数的返回值，
    // 同样，将其右子结点更新为对其右子结点调用递归函数的返回值。最后返回root即可
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
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
