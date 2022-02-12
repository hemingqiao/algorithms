package src.backtrack.pathsofsumlcci0412;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 16:28:20
 * description:
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 *
 * 参考：https://leetcode-cn.com/problems/paths-with-sum-lcci/solution/javahui-su-by-madridista/
 */
public class Solution {
    // 总体思路是回溯，以每个节点为起点，向下遍历树，当走过的路径和为sum时，更新res。
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        backtracking(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void backtracking(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val; // 减去当前节点的值，继续向下递归
        if (sum <= 0) {
            if (sum == 0) {
                count++;
            }
            return;
        }
        backtracking(root.left, sum);
        backtracking(root.right, sum);
        //sum += root.val; // 不需要进行回溯，因为sum是int类型，是按值传递的，不是引用传递
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
