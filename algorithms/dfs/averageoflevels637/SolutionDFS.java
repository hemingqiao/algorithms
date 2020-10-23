package blogandquestion.algorithms.dfs.averageoflevels637;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/23 19:39:56
 * description: 利用DFS后序遍历，需要维护两个数组，一个记录每一层的节点值总和，另一个记录每一层的节点数。
 * 这个执行的比较快，击败98.7，但是内存消耗比较大。
 */
public class SolutionDFS {
    private List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    private void dfs(TreeNode root, int depth, List<Integer> counts, List<Double> sums) {
        if (root == null) return;
        if (depth < sums.size()) {
            sums.set(depth, sums.get(depth) + root.val);
            counts.set(depth, counts.get(depth) + 1);
        } else {
            sums.add(root.val * 1.0);
            counts.add(1);
        }
        depth++;
        dfs(root.right, depth, counts, sums);
        dfs(root.left, depth, counts, sums);
    }
}
