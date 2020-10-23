package blogandquestion.algorithms.dfs.levelorder429;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/23 20:21:52
 * description: DFS加先序遍历，执行速度比较快，能够击败100，空间消耗也能击败95。
 */
public class SolutionDFS {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    // dfs通过记录深度的变量depth和res.size的关系，来判断遍历到了哪一层
    // 如果depth恰好等于res.size，说明遍历到了这一层的第一个元素，向res中加入一个新数组，如果depth小于res.size，是在遍历
    // 这一层的其他元素，将其加入depth对应的数组中
    private void dfs(Node root, int depth) {
        if (root == null) return;
        if (depth < res.size()) {
            res.get(depth).add(root.val);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        }
        depth++;
        for (Node n : root.children) {
            dfs(n, depth);
        }
    }
}
