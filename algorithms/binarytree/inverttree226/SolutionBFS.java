package blogandquestion.algorithms.binarytree.inverttree226;

import java.util.LinkedList;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 20:23:10
 * description: 广度优先遍历解决翻转二叉树
 * 解题思路
 * see: https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
 */
public class SolutionBFS {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 将二叉树的节点依次放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每次都从队列中出队一个节点，并交换这个节点的左右子树
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            // 如果当前节点的左子树不为空，则放入队列等待后续处理
            if (temp.left != null) queue.add(temp.left);
            // 如果当前队列的右子树不为空，则放入队列等待后续处理
            if (temp.right != null) queue.add(temp.right);
        }
        return root;
    }
}
