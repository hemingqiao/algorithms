package blogandquestion.algorithms.dfs.maxdepth559;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/22 16:37:53
 * description: 可能相对好理解一些。
 */
public class AnotherSolution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        return dfs(root) + 1;
    }

    private int dfs(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, root.children.get(i) == null ? 0 : dfs(root.children.get(i)) + 1);
        }
        return depth;
    }
}
