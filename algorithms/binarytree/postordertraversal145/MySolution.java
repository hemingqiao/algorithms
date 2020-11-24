package blogandquestion.algorithms.binarytree.postordertraversal145;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 13:07:45
 * description:
 */
public class MySolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pollLast();
            res.add(temp.val);
            // 先序遍历是中左右，先将右子节点压栈，再将左子节点压栈，出栈顺序是左子节点、右子节点
            // 这里调整为中右左，先将左子节点压栈，再将右子节点压栈，出栈顺序是右子节点、左子节点
            // 最后翻转一下结果列表，就是左右中后序遍历了
            if (temp.left != null) {
                stack.add(temp.left);
            }
            if (temp.right != null) {
                stack.add(temp.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 将结果插入头部
     * 参考：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/die-dai-jie-fa-shi-jian-fu-za-du-onkong-jian-fu-za/384697
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return res;
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
