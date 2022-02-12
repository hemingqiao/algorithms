package src.binarytree.inordertraversal94;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/28 19:07:48
 * description: 迭代法实现树的中序遍历。
 * 解题思路
 * see: https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247484677&idx=1&sn=e04b4a5baa7a3f6b090947bfa8aea97a&scene=21#wechat_redirect
 * see: https://mp.weixin.qq.com/s/-ZJn3jJVdF683ap90yIj4Q
 */
public class AnotherSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; // 处理左节点
            } else {
                // cur为null，开始处理中间节点和右子树的节点
                cur = stack.pop();
                list.add(cur.val); // 处理中间节点
                cur = cur.right; // 处理右节点
            }
        }
        return list;
    }
}


/*class TreeNode {
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
}*/
