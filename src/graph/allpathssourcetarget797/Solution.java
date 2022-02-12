package src.graph.allpathssourcetarget797;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/27 20:57:50
 * description:
 * 参考：https://leetcode-cn.com/problems/all-paths-from-source-to-target/solution/c-hui-su-ti-jie-by-da-li-wang/
 */
public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); // 添加起点
        backtrace(graph, graph.length, 0, res, path);
        return res;
    }

    // 深度优先搜索加回溯
    public void backtrace(int[][] graph, int size, int depth,
                          List<List<Integer>> res, List<Integer> path) {
        if (depth == size - 1) {
            res.add(new ArrayList<>(path));
            return;
        } else {
            // 加一个else之后执行速度会快一些
            for (int i : graph[depth]) {
                path.add(i); // 做出选择
                backtrace(graph, size, i, res, path); // 递归调用，注意这里传入的depth是i
                path.remove(path.size() - 1); // 撤销选择，回溯
            }
        }
    }
}

class AnotherSolution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrace(graph, graph.length - 1, 0, path);
        return res;
    }

    private void backtrace(int[][] graph, int size, int depth, List<Integer> path) {
        if (depth == size) {
            res.add(new ArrayList<>(path));
            return;
        } else {
            for (int i = 0; i < graph[depth].length; i++) {
                int cur = graph[depth][i];
                path.add(cur);
                backtrace(graph, size, cur, path);
                path.remove(path.size() - 1);
            }
        }
    }
}

class AnotherSolution1 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        backtrace(graph, graph.length - 1, 0, new ArrayList<>());
        return res;
    }

    private void backtrace(int[][] graph, int size, int depth, List<Integer> path) {
        path.add(depth);
        if (depth == size) {
            res.add(new ArrayList<>(path));
            return;
        } else {
            for (int i = 0; i < graph[depth].length; i++) {
                backtrace(graph, size, graph[depth][i], path);
                path.remove(path.size() - 1);
            }
        }
    }
}
