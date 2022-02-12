package src.dfs.maxancestordiff1026;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/04 22:10:03
 * description:定义一个全局变量保存最大差值，利用dfs找到每条路径上的节点最大值和最小值，当到达叶子节点时，更新全局变量。
 * 解题思路
 * see: https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/solution/java-dfs-by-zxy0917-4/
 *
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 *
 */
public class Solution {
    int res = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return res;
    }

    // 得出一条路径上的最大值和最小值之差的绝对值，并与res比较并更新结果
    private void dfs(TreeNode root, int max, int min) {
        if (root == null) return;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        if (root.left == null && root.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }
        dfs(root.left, max, min);
        dfs(root.right, max, min);
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
