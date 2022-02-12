package src.binarytree.sumroottoleaf1022;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/05 21:00:56
 * description:
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：root = [1,1]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 *
 */
public class Solution {
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int temp) {
        temp = temp * 2 + root.val;
        // 退出条件是到达叶子节点，为了方便，将对当前节点的操作移到了最前面
        if (root.left == null && root.right == null) {
           res += temp;
           return;
        }

        if (root.left != null) dfs(root.left, temp);
        if (root.right != null) dfs(root.right, temp);
    }

    public static void main(String[] args) {
        String x = "0101";
        System.out.println(Integer.parseInt(x, 2));
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
