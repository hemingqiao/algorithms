package blogandquestion.algorithms.binarytree.postorder590;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/08 12:06:28
 * description:
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 *
 */
public class Solution {
    // 递归解法
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node node : root.children) {
            dfs(node, res);
        }
        res.add(root.val);
    }
}

/**
 * 迭代解法
 */
class AnotherSolution {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        List<Integer> res = new LinkedList<>();
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            // 注意这里是插入到头部，保证结果是后序遍历
            res.add(0, temp.val);
            for (Node node : temp.children) {
                if (node != null) stack.push(node);
            }
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
