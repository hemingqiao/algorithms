package blogandquestion.algorithms.dfs.zigzaglevelorder103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 16:19:29
 * description: 和一般的DFS中序遍历唯一不同就是奇数层和偶数层的插入顺序不一样。
 */
public class MySolutionDFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int depth = 0;
        dfs(root, depth, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> list) {
        if (root == null) return;
        if (depth < list.size()) {
            if (depth % 2 == 0) {
                list.get(depth).add(root.val); // 偶数层将节点值添加到尾部
            } else {
                list.get(depth).add(0, root.val); // 奇数层将节点值插入到头部
            }
        } else {
            LinkedList<Integer> temp = new LinkedList<>(); // 需要在奇数层和偶数层交换插入的顺序，可以使用LinkedList从头部插入
            temp.add(root.val);
            list.add(temp);
        }

        depth++;
        dfs(root.left, depth, list);
        dfs(root.right, depth, list);
    }
}
