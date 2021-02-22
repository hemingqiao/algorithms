package blogandquestion.algorithms.binarytree.constructbinarytree.buildtree105;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/22 22:00:13
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(map, preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode help(Map<Integer, Integer> map, int[] preorder, int p_start, int p_end,
                         int[] inorder, int i_start, int i_end) {
        // 区间是左闭右开的，如果start == end，表明已经没有元素了
        if (p_start == p_end) return null;
        int rootVal = preorder[p_start];
        TreeNode root = new TreeNode(rootVal);
        int pos = map.get(rootVal);
        int leftNum = pos - i_start; // 从中序遍历数组中读出当前根节点的左子节点个数
        // p_start + 1 跳过当前的根节点，范围是从新的p_start到加上左子树结点个数，注意是左闭右开区间
        root.left = help(map, preorder, p_start + 1, p_start + 1 + leftNum, inorder, i_start, pos);
        // pos + 1 跳过中序遍历数组中根节点的位置
        root.right = help(map, preorder, p_start + 1 + leftNum, p_end, inorder, pos + 1, i_end);
        return root;
    }
}
