package src.binarytree.lowestcommonancestor236;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 19:09:40
 * description:
 * 参考：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/javadai-ma-di-gui-he-fei-di-gui-tu-wen-xiang-jie-b/
 * 参考：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/c-jing-dian-di-gui-si-lu-fei-chang-hao-li-jie-shi-/
 *
 * 参考：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
 */
public class AnotherSolution {
    // 题目限定了p和q一定都在二叉树中存在，那么如果当前结点不等于p或q，p和q要么分别位于左右子树中，要么同时位于左子树，或者同时位于右子树，
    // 那么分别来讨论：
    //- 若p和q分别位于左右子树中，那么对左右子结点调用递归函数，会分别返回p和q结点的位置，而当前结点正好就是p和q的最小共同父结点，
    // 直接返回当前结点即可，这就是题目中给出的例子1的情况。
    //- 若p和q同时位于左子树，这里有两种情况，一种情况是 left 会返回p和q中较高的那个位置，而 right 会返回空，所以最终返回非空的 left 即可，
    // 这就是题目中的例子2的情况。还有一种情况是会返回p和q的最小父结点，就是说当前结点的左子树中的某个结点才是p和q的最小父结点，会被返回。
    //- 若p和q同时位于右子树，同样有两种情况，一种情况是 right 会返回p和q中较高的那个位置，而 left 会返回空，所以最终返回非空的 right 即可，
    // 还有一种情况是会返回p和q的最小父结点，就是说当前结点的右子树中的某个结点才是p和q的最小父结点，会被返回
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
