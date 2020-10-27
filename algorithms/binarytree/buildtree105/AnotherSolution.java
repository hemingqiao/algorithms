package blogandquestion.algorithms.binarytree.buildtree105;

import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/27 19:00:15
 * description: 用一个HashMap把中序遍历数组的每个元素的值和下标存起来，这样寻找根节点的位置时就可以直接找到了。
 * 解题思路
 * see: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 */
public class AnotherSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeAux(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeAux(
            int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        if (p_start == p_end) return null; // 如果preorder数组为空，直接返回null
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val); // 直接从map中获取中序遍历数组中根节点的位置
        int leftNum = i_root_index - i_start;
        root.left = buildTreeAux(preorder, p_start + 1, p_start + 1 + leftNum, inorder, i_start, i_root_index, map);
        root.right = buildTreeAux(preorder, p_start + 1 + leftNum, p_end, inorder, i_root_index + 1, i_end, map);
        return root;
    }
}
