package src.dfs.largestvalues515;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/30 19:14:42
 * description: 似曾相识的解法。DFS一般都是比BFS要快不少的。
 * 解题思路
 * see: https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/solution/javadai-ma-bfshe-dfsliang-chong-jie-jue-si-lu-yi-j/
 */
public class SolutionDFS {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    // 0代表第一层，1代表第二层，依次递推
    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (level == res.size()) { // level等于res的size时，代表首次进入这一层
            res.add(root.val);
        } else if (level < res.size()) { // 遍历到了同一层（深度）的节点，非首次进入这一层时，level会小于res.cnt()
            res.set(level, Math.max(res.get(level), root.val));
        }
        level++; // 进入下一层
        dfs(root.left, res, level); // level是值传递，这里隐含有回溯
        dfs(root.right, res, level);
    }
}
