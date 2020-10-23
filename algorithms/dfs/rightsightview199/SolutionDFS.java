package blogandquestion.algorithms.dfs.rightsightview199;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/23 19:22:08
 * description: 利用DFS后序遍历。增加一个辅助变量depth记录深度。妙啊
 * 解题思路
 * see: https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
 */
public class SolutionDFS {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        // 先访问当前节点，在递归的访问右子树和左子树
        if (depth == list.size()) {
            list.add(root.val); // 如果当前节点所在深度还没有出现在list中，说明该深度下当前节点是第一个被访问的处于右侧的节点，将给节点的值加入list
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
