package blogandquestion.algorithms.binarytree.lowestcommonancestor236;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/12 20:29:52
 * description: 利用BST的性质（根节点的值大于左子树的所有节点值，小于右子树的所有节点值）
 */
public class BSTSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if (root.val > max) {
            // root.val大于p和q中的较大值
            // 表明p和q都位于root的左子树中，返回左子树的搜索结果
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < min) {
            // root.val小于p和q中的较小值
            // 表明p和q都位于root的右子树中，返回右子树的搜索结果
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
