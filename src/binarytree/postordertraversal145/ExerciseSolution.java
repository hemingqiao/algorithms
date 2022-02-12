package src.binarytree.postordertraversal145;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/22 21:40:54
 * description:
 */
public class ExerciseSolution {
    // 先序遍历的顺序是 中 -> 左 -> 右
    // 可以调整为 中 -> 右 -> 左，如果倒序，就是 左 -> 右 -> 中，即后序遍历
    // 所以，在先序遍历的基础上，在向list中添加值时，添加到头部，就形成倒序的结果，即后续遍历的结果
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
           while (root != null) {
               stack.push(root);
               list.addFirst(root.val);
               root = root.right;
           }
           root = stack.pop();
           root = root.left;
        }
        return list;
    }

    // 三刷
    // 2020/02/28
    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                list.add(0, root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return list;
    }
}
