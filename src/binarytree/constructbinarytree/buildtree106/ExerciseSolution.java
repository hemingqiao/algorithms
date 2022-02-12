package src.binarytree.constructbinarytree.buildtree106;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/22 22:24:45
 * description:
 */
public class ExerciseSolution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(map, inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode help(Map<Integer, Integer> map, int[] inorder, int i_start, int i_end,
                         int[] postorder, int p_start, int p_end) {
        // 左闭右开区间，如果左边界和右边界相等，表明已经没有元素了
        if (p_start == p_end) return null;
        int rootVal = postorder[p_end - 1];
        TreeNode root = new TreeNode(rootVal);
        int pos = map.get(rootVal);
        int leftNum = pos - i_start; // 当前根节点的左子树的结点个数
        root.left = help(map, inorder, i_start, pos, postorder, p_start, p_start + leftNum);
        // p_end减去1，跳过后序遍历数组中当前的根节点，pos + 1，跳过中序遍历数组中的根节点
        root.right = help(map, inorder, pos + 1, p_end, postorder, p_start + leftNum, p_end - 1);
        return root;
    }
}
