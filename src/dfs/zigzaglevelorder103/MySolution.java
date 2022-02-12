package src.dfs.zigzaglevelorder103;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 16:13:21
 * description: BFS层序遍历，奇数层逆转数组。时间效率比较低，只能击败14。
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 *
 */
public class MySolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            if (depth % 2 != 0) {
                Collections.reverse(temp);
            }
            depth++;
            res.add(temp);
        }
        return res;
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
