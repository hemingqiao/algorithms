package blogandquestion.algorithms.dfs.preorder589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/27 08:44:13
 * description: 迭代解法待补充。
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class MySolution {
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), list);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
