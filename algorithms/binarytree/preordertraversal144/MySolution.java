package blogandquestion.algorithms.binarytree.preordertraversal144;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 13:01:08
 * description:
 * 迭代实现二叉树的先序遍历。
 * 参考：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 */
public class MySolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pollLast();
            res.add(temp.val); // 处理根节点
            // 先将右子结点压栈，再将左子节点压栈，这样，出栈顺序就是左子节点、右子节点
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        }
        return res;
    }
}
