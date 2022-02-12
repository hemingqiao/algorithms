package src.dfs.findbottomleftvalue513;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/24 10:20:45
 * description: DFS加先序遍历，把每一层第一个遇到的节点值加入list，因为是先序遍历，所以每一层第一个遇到的节点必然是位于左下角的。
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 *
 */
public class SolutionDFS {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list.get(list.size() - 1);
    }

    private void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;
        if (depth == list.size()) {
            list.add(root.val);
        }
        depth++;
        dfs(root.left, depth, list);
        dfs(root.right, depth, list);
    }
}
