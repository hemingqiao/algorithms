package src.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 20:53:58
 * description:
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 *
 */
public class LevelOrderOffer32Two {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        } else {
            res.get(depth).add(root.val);
        }

        dfs(res, root.left, depth + 1);
        dfs(res, root.right, depth + 1);
    }
}
