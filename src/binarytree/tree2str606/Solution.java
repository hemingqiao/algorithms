package src.binarytree.tree2str606;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/05 21:24:42
 * description:
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 *
 * 参考：https://github.com/grandyang/leetcode/issues/606
 */
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String res = String.valueOf(t.val);
        String left = tree2str(t.left), right = tree2str(t.right);
        // 左右子树均为空
        if (left.equals("") && right.equals("")) return res;
        // 左子树为空
        if (left.equals("")) return res + "()" + "(" + right + ")";
        // 右子树为空
        if (right.equals("")) return res + "(" + left + ")";
        // 左右子树均不为空
        return res + "(" + left + ")" + "(" + right + ")";
    }
}

class AnotherSolution {
    // 使用StringBuilder替代字符串拼接，直接快了11ms(17 -> 6)
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder res = new StringBuilder();
        res.append(t.val);
        String left = tree2str(t.left), right = tree2str(t.right);
        // 左右子树均为空
        if (left.equals("") && right.equals("")) return res.toString();
        // 左子树为空
        if (left.equals("")) return res.append("()").append("(").append(right).append(")").toString();
        // 右子树为空
        if (right.equals("")) return res.append("(").append(left).append(")").toString();
        // 左右子树均不为空
        return res.append("(").append(left).append(")").append("(").append(right).append(")").toString();
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
