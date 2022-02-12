package src.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 21:07:59
 * description:
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 *
 */
public class LevelOrderOffer32Three {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(root.val);
            res.add(temp);
        } else {
            if ((depth & 1) == 0) { // 奇数层
                res.get(depth).add(root.val);
            } else {
                // 偶数层在头部添加
                res.get(depth).add(0, root.val);
            }
        }
        dfs(res, root.left, depth + 1);
        dfs(res, root.right, depth + 1);
    }
}
