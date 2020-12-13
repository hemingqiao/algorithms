package blogandquestion.algorithms.dfs.pathsum437;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 16:26:33
 * description:
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return calcPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int calcPathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        // 在每一层要做的事：判断减去当前节点后，sum是否为0，即当前节点是否是满足题意的路径
        // 如果sum等于0，使用temp记录路径数，然后递归进入左右子树
        int temp = 0;
        sum -= root.val;
        if (sum == 0) {
            temp++;
        }
        return temp + calcPathSum(root.left, sum) + calcPathSum(root.right, sum);
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
