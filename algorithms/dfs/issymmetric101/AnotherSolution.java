package blogandquestion.algorithms.dfs.issymmetric101;

import java.util.LinkedList;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 19:57:37
 * description: 迭代解法，BFS通常要比DFS慢上不少。
 * 解题思路
 * see: https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
 */
public class AnotherSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        // 用链表作为队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            // 如果两个节点的为空，继续循环，如果有一个为空，返回false
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            // 按顺序依次将左节点的左子树，右节点的右子树，左节点的右子树和右节点的左子树加入队列
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
