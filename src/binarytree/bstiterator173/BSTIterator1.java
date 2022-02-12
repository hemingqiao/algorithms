package src.binarytree.bstiterator173;

import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 10:09:21
 * description:
 */
public class BSTIterator1 {
    // 利用二叉树的中序遍历的迭代实现
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator1(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    public int next() {
        TreeNode t = stack.pop();
        int val = t.val;
        TreeNode temp = t.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
