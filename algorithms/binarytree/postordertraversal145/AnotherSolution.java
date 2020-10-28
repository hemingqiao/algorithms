package blogandquestion.algorithms.binarytree.postordertraversal145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/28 19:35:40
 * description: 取巧的用迭代实现后序遍历。
 * 解题思路
 * see: https://mp.weixin.qq.com/s/-ZJn3jJVdF683ap90yIj4Q
 */
public class AnotherSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) res.add(node.val);
            else continue;
            stack.push(node.left); // 先序遍历是中左右，这里改变顺序为中右左，然后反转list就变为左右中的后序遍历了
            stack.push(node.right); // 这种解法取巧了
        }
        Collections.reverse(res);
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
