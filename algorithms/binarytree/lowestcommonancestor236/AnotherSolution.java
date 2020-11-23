package blogandquestion.algorithms.binarytree.lowestcommonancestor236;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 19:09:40
 * description:
 * 参考：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/javadai-ma-di-gui-he-fei-di-gui-tu-wen-xiang-jie-b/
 * 参考：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/c-jing-dian-di-gui-si-lu-fei-chang-hao-li-jie-shi-/
 */
public class AnotherSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            // 如果查找到两个节点都不在根节点的左子树，返回右子树查找到的第一个目标节点
            return right;
        }
        if (right == null) {
            // 如果查找的两个节点都不在根节点的右子树，则返回左子树查找到的第一个目标节点
            return left;
        }
        // 如果left和right均不为null，表明根节点左右子树各存在一个目标节点，此时只能返回根节点
        return root;
    }
}
