package blogandquestion.algorithms.graph.clonegraph133;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/22 22:08:17
 * description:
 *
 */
public class ExerciseSolution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        dfs(node); // 复制节点
        for (Map.Entry<Node, Node> entry : map.entrySet()) { // 复制所有的边
            Node key = entry.getKey(), copy = entry.getValue();
            for (Node n : key.neighbors) {
                copy.neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    public void dfs(Node node) {
        map.put(node, new Node(node.val));
        for (Node n : node.neighbors) {
            if (!map.containsKey(n)) dfs(n);
        }
    }

    Map<Node, Node> d = new HashMap<>();

    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        bfs(node);
        // 复制所有的边
        for (Map.Entry<Node, Node> entry : d.entrySet()) {
            Node key = entry.getKey(), copy = entry.getValue();
            for (Node edge : key.neighbors) {
                copy.neighbors.add(d.get(edge));
            }
        }
        return d.get(node);
    }

    public void bfs(Node node) {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);
        d.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (Node nn : n.neighbors) {
                if (!d.containsKey(nn)) {
                    q.offer(nn);
                    d.put(nn, new Node(nn.val));
                }
            }
        }
    }
}
