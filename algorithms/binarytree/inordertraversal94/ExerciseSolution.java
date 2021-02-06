package blogandquestion.algorithms.binarytree.inordertraversal94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/06 22:26:13
 * description:
 */
public class ExerciseSolution {
    // 中序遍历的迭代写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
