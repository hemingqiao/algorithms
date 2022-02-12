package src.binarytree.preordertraversal144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/28 19:26:20
 * description: 迭代法实现先序遍历。
 * 解题思路
 * see: https://mp.weixin.qq.com/s/-ZJn3jJVdF683ap90yIj4Q
 */
public class AnotherSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) res.add(temp.val);
            else continue;
            // 如果栈顶节点不为null，将栈的右节点和左节点推入栈中
            stack.push(temp.right); // 先将右节点压栈，在将左节点压栈，出栈顺序就是左节点，右节点
            stack.push(temp.left);
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
