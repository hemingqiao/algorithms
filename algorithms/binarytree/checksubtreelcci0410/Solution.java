package blogandquestion.algorithms.binarytree.checksubtreelcci0410;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/07 20:45:57
 * description:
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 *
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 *
 * 示例1:
 *
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 * 示例2:
 *
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 * 提示：
 *
 * 树的节点数目范围为[0, 20000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-subtree-lcci
 *
 * 本题是isSameTree(100)的进阶版
 * 参考：https://leetcode-cn.com/problems/check-subtree-lcci/solution/jian-cha-zi-shu-jin-100dai-ma-jian-ji-zhu-shi-xian/626604
 */
public class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
        if (t2 == null) return true;
        return isSub(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean isSub(TreeNode t1, TreeNode t2) {
        // 注意，要先判断要检查的子树t2
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (t1.val != t2.val) return false;
        return isSub(t1.left, t2.left) && isSub(t1.right, t2.right);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/check-subtree-lcci/solution/java-di-gui-qiu-jie-by-npe_tle-3/
 */
class AnotherSolution {
    // 遍历t1的每个节点，判断以t1中的每个节点为根的子树是否与t2完全相同
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2 == null;
        return isSameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    // 判断两个二叉树是否完全相同
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
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
