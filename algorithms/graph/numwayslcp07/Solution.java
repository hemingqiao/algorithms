package blogandquestion.algorithms.graph.numwayslcp07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/01 21:44:42
 * description:
 */
public class Solution {
    int res, n, k;
    List<List<Integer>> edges;
    List<List<Integer>> paths;

    public int numWays(int n, int[][] r, int k) {
        this.n = n;
        this.k = k;
        this.edges = new ArrayList<>();
        this.paths = new ArrayList<>();
        for (int i = 0; i < n; i++) edges.add(new ArrayList<>());
        for (int[] relation : r) edges.get(relation[0]).add(relation[1]);
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, 0, path);
        return res;
    }

    public void dfs(int step, int p, List<Integer> path) {
        if (step == k) {
            if (p == n - 1) {
                ++res;
                paths.add(new ArrayList<>(path));
            }
            return;
        }
        List<Integer> t = edges.get(p);
        for (int i : t) {
            path.add(i);
            dfs(step + 1, i, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] r = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        Solution s = new Solution();
        int res = s.numWays(5, r, 3);
        System.out.println(res);
    }
}


class AnotherSolution {
    int res, n, k;
    List<List<Integer>> edges;

    public int numWays(int n, int[][] r, int k) {
        this.n = n;
        this.k = k;
        this.edges = new ArrayList<>();
        for (int i = 0; i < n; i++) edges.add(new ArrayList<>());
        for (int[] relation : r) edges.get(relation[0]).add(relation[1]);
        dfs(0, 0);
        return res;
    }

    public void dfs(int step, int p) {
        if (step == k) {
            if (p == n - 1) ++res;
            return;
        }
        List<Integer> t = edges.get(p);
        for (int i : t) dfs(step + 1, i);
    }
}
