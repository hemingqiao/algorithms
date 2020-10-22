package blogandquestion.algorithms.dfs.maxdepth559;

import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/22 16:33:44
 * description: 深度优先搜索。
 * 解题思路
 * see: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/qiu-shu-de-zui-da-shen-du-xiang-jie-by-carlsun-2/
 *
 * 题目描述：
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth + 1;
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
