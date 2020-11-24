package blogandquestion.algorithms.binarytree.getallelements1305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 21:57:19
 * description:
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 */
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1, res);
        dfs(root2, res);
        Collections.sort(res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/solution/java-san-chong-jie-fa-by-npe_tle/
 */
class AnotherSolution {
    // 题目限定两棵树都是二叉搜索树，而二叉搜索树的中序遍历结果是有序的，可以利用这一点
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>(),
                r2 = new ArrayList<>();
        dfs(root1, r1);
        dfs(root2, r2);
        return merge(r1, r2);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int size1 = list1.size(), size2 = list2.size();
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if (list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }
        while (i < size1) {
            res.add(list1.get(i++));
        }
        while (j < size2) {
            res.add(list2.get(j++));
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
