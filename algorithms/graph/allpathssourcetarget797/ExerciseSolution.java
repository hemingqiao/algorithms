package blogandquestion.algorithms.graph.allpathssourcetarget797;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/25 20:50:08
 * description:
 */
public class ExerciseSolution {
    int[][] g;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = graph.length;
        dfs(0);
        return ans;
    }

    public void dfs(int u) {
        path.add(u);
        if (u == n - 1) {
            ans.add(new ArrayList<>(path)); // 这里没有return，是需要把最后一步添加进path的节点删除，进行回溯
        }
        for (int i : g[u]) dfs(i);
        path.remove(path.size() - 1);
    }
}
