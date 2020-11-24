package blogandquestion.algorithms.binarytree.kthlargestlcof54;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 22:22:55
 * description:
 * 参考：https://leetcode-cn.com/problems/next-greater-element-i/solution/3chong-jie-fa-dan-shi-pu-tong-jie-fa-shi-ji-yong-s/
 */
public class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res.get(res.size() - k);
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }
}

/**
 * 中序遍历的递归写法
 */
class AnotherSolution {
    // 二叉搜索树的中序遍历得到的是有序序列
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 只要节点的右子节点不为空，一直将右子节点压栈
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            // 当某个节点的右子节点为空时，处理当前节点（根的值）
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            // 处理当前节点的左子节点
            root = root.left;
        }
        return 0;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
