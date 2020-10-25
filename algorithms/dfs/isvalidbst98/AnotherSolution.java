package blogandquestion.algorithms.dfs.isvalidbst98;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/25 09:17:12
 * description: 根据二叉搜索树的性质，中序遍历的结果一定是有序的。如果中序遍历时，当前节点的值不大于前一个节点的值，
 * 表明不是一个有效的二叉搜索树。
 * 接替思路
 * see: https://mp.weixin.qq.com/s/B9zmMQDCSWanjHCCwUSAuA
 */
public class AnotherSolution {
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false; // 访问左子树
        // 如果当前节点的值小于等于前一个节点的值，返回false
        // 判断prev为null是针对根节点，prev的初始值为null，跳过判断语句，prev赋值为根节点
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        if (!isValidBST(root.right)) return false; // 访问右子树
        return true;
    }
}
