package src.dfs.diameterofbinarytree543;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/19 08:50:56
 * description: 利用深度优先搜索。
 * see: https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/java-1zhao-zou-tian-xia-by-sweetiee/
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 *
 */
public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    // 找出以root为根节点的最大深度
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int leftSize = root.left == null ? 0 : dfs(root.left) + 1;
        int rightSize = root.right == null ? 0 : dfs(root.right) + 1;
        // 对于当前节点root而言，最大深度可能是root+left、root+right、root或者left + root + right
        // dfs不会返回第四种，那种路径不会成立，但是需要比较第四种的路径长度和max的大小
        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/dfs-by-mike-meng-21/
 */
class AnotherSolution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    // dfs方法返回以root为根节点的最大深度
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
