package blogandquestion.algorithms.graph.clonegraph133;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 20:14:36
 * description:
 * 参考：https://leetcode-cn.com/problems/clone-graph/solution/dfs-he-bfs-by-powcai/
 * 参考：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
 */
public class Solution {
    // 深度优先遍历求解
    public Node cloneGraph(Node node) {
        // map用来解决循环引用
        Map<Node, Node> lookup = new HashMap<>();
        return clone(lookup, node);
    }

    private Node clone(Map<Node, Node> lookup, Node node) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(clone(lookup, n));
        }
        return clone;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
 */
class OfficialSolution {
    // map用来解决循环引用
    Map<Node, Node> lookup = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (lookup.containsKey(node)) return lookup.get(node);

        // 克隆节点，注意到为了深拷贝不会克隆它的邻居的列表
        Node clone = new Node(node.val, new ArrayList<>());
        // 存储到哈希表中
        lookup.put(node, clone);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}

/**
 * 广度优先遍历
 */
class SolutionBFS {
    // BFS广度优先遍历解决
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.pollLast();
            for (Node n : temp.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.add(n);
                }
                lookup.get(temp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
