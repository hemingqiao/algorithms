package src.binarytree.findsecondminimumvalue671;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/07 18:44:51
 * description:
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1：
 *
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 *
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 *
 */
public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        Collections.sort(res);
        int pre = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) != pre) {
                return res.get(i);
            }
        }
        return -1;
    }

//    private void dfs(TreeNode root, List<Integer> list) {
//        if (root == null) return;
//        list.add(root.val);
//        dfs(root.left, list);
//        dfs(root.right, list);
//    }

    // 把判空放在了上一层的逻辑中而不是通过base case
    private void dfs(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) dfs(root.left, list);
        if (root.right != null) dfs(root.right, list);
    }
}

/**
 * 参考：https://github.com/grandyang/leetcode/issues/671
 */
class AnotherSolution {
    // c = min(a, b) => c == a || c == b || c == a == b
    // c是a、b之中的较小值，那么c要么等于a，要么等于b，或者c等于a和b
    public int findSecondMinimumValue(TreeNode root) {
        // 题目限定一个节点要么有两个子节点，要么一个都没有，可以通过判断c的左子节点或者右子节点是否为空
        if (root.left == null) return -1;
        int left = (root.val == root.left.val) ? findSecondMinimumValue(root.left) : root.left.val;
        int right = (root.val == root.right.val) ? findSecondMinimumValue(root.right) : root.right.val;
        return (left == -1 || right == -1) ? Math.max(left, right) : Math.min(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
