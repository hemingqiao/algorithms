package blogandquestion.algorithms.binarytree.getminimumdifference530;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/13 14:02:47
 * description:
 */
public class ExerciseSolution {
    public int minDiffInBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int pre = -1;
        int res = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != -1) res = Math.min(res, root.val - pre);
            pre = root.val;
            root = root.right;
        }
        return res;
    }
}
