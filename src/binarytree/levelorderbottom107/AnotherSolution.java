package src.binarytree.levelorderbottom107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/22 22:38:06
 * description: 使用DFS解决。妙啊
 * 解题思路
 * see: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/san-chong-shi-xian-tu-jie-107er-cha-shu-de-ceng-ci/
 */
public class AnotherSolution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, lists, 1);
        Collections.reverse(lists); // 将list反转
        return lists;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, int index) {
        if (root == null) return;
        if (index > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(index - 1).add(root.val);
        dfs(root.left, list, index + 1);
        dfs(root.right, list, index + 1);
    }
}
