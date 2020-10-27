package blogandquestion.algorithms.binarytree.buildtree106;

import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/27 19:14:18
 * description: 参考了105题的解法，看了官方题解还有迭代的解法，回头重刷时在学习下。
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeAux(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    private TreeNode buildTreeAux(
            int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end, HashMap<Integer, Integer> map) {
        if (i_start == i_end) return null;
        int root_val = postorder[p_end - 1]; // 因为是左闭右开区间，所以数组最后一个值的索引是end - 1
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int rightNum = i_end - 1 - i_root_index;
        // i_end和p_end都是取不到的，也就是区间是左闭右开的
        // 递归构造右子树和左子树
        root.right = buildTreeAux(inorder, i_end - rightNum, i_end, postorder, p_end - 1 - rightNum, p_end - 1, map);
        root.left = buildTreeAux(inorder, i_start, i_end - rightNum - 1, postorder, p_start, p_end - 1 - rightNum, map);
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
