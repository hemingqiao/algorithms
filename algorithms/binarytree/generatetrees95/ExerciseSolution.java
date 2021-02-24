package blogandquestion.algorithms.binarytree.generatetrees95;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/24 19:49:42
 * description:
 */
public class ExerciseSolution {
    /*
    这种建树问题一般来说都是用递归来解，这道题也不例外，划分左右子树，递归构造。这个其实是用到了大名鼎鼎的分治法 Divide and Conquer。

    用递归来解，划分左右两个子数组，递归构造。刚开始时，将区间 [1, n] 当作一个整体，然后需要将其中的每个数字都当作根结点，由此划分开了左右两个
    子区间，然后分别调用递归函数，会得到两个结点数组，接下来要做的就是从这两个数组中每次各取一个结点，当作当前根结点的左右子结点，然后将根结点
    加入结果 res 数组中即可
     */

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    // start和end决定了选取结点的区间
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftNodes = helper(start, i - 1);
                List<TreeNode> rightNodes = helper(i + 1, end);
                for (TreeNode left : leftNodes) {
                    for (TreeNode right : rightNodes) {
                        TreeNode temp = new TreeNode(i);
                        temp.left = left;
                        temp.right = right;
                        list.add(temp);
                    }
                }
            }
        }
        return list;
    }
}
