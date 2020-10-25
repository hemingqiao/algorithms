package blogandquestion.algorithms.dfs.searchbst700;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 19:35:55
 * description: 这个确实是简单难度。
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 *
 */
public class MySolution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        // 利用二叉搜索树的性质，左子树的值小于右子树的值
        // 当root的值大于目标值时，只需要搜索左子树，反之搜索右子树
        else if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
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
