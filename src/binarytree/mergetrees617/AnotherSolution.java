package src.binarytree.mergetrees617;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/09 19:04:46
 * description: 官方题解，比我写的简洁多了，但是执行时间差别不大。
 * 解题思路
 * see: https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/
 */
public class AnotherSolution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
