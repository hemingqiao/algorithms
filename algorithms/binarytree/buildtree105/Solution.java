package blogandquestion.algorithms.binarytree.buildtree105;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/27 18:33:08
 * description: 根据先序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，它的右边就是右子树的节点。
 * 然后递归的生成左子树和右子树。
 * 解题思路
 * see: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeAux(
                preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeAux(
            int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) return null; // preorder数组为空，直接返回null

        int root_val = preorder[p_start]; // 先序遍历的数组第一个元素为根元素
        TreeNode root = new TreeNode(root_val);
        int i_root_index = 0; // 遍历中序数组，找到根元素的位置
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start; // 从中序遍历数组中得到左子树节点个数
        // 递归的构造左子树
        root.left = buildTreeAux(preorder, p_start + 1, p_start + 1 + leftNum, inorder, i_start, i_root_index);
        // 递归的构造右子树
        root.right = buildTreeAux(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
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
