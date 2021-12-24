package blogandquestion.algorithms.dfs.increasingbst897;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/25 19:34:01
 * description:
 */
public class ExerciseSolution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        int size = list.size(), p = 0;
        TreeNode ret = new TreeNode(list.get(p++));
        TreeNode temp = ret;
        while (p < size) {
            temp.right = new TreeNode(list.get(p++));
            temp = temp.right;
        }
        return ret;
    }

    public void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

    /*
    这道题给了一棵二叉树，让对其进行重排序，使得最左结点变为根结点，而且整个树不能有左子结点，如题目中的例子所示，排序后的结果是一条向右下方
    延伸的直线。如果仔细观察题目中的例子，可以发现遍历顺序其实是 左->根->右，就是中序遍历的顺序，虽然题目中没说是二叉搜索树，但这并不影响我们
    进行中序遍历。先从最简单的例子开始分析，当 root 为空时，直接返回空，当 root 没有左右子结点时，也是直接返回 root。当 root 只有一个左
    子结点时，我们此时要把其左子结点变为根结点，将原来的根结点变成其原来的左子结点的右子结点。但是如果 root 只有一个右子结点，还是保持原来的顺序
    不变，而若 root 同时具有左右子结点的话，还是要将左子结点变为根结点，然后把之前的根结点连到右子结点上，之前的右子结点还连在之前的根结点上，
    这个不用改变。我们可以发现，最麻烦的就是左子结点了，需要和其根结点交换位置，所以对于每个结点，我们需要知道其父结点的位置，那么就在递归函数的
    参数中传入一个 pre 结点，再对左右子结点调用递归函数时，都将其下一个要连接的结点传入，这个 pre 结点可能是当前结点或者当前结点的父结点。

    在递归函数中，首先判空，若当前结点为空的话，直接返回 pre 结点，因为到空结点的时候，说明已经遍历到叶结点的下方了，那么 pre 就是这个叶结点了。
    由于是中序遍历，所以要先对左子结点调用递归函数，将返回值保存到一个新的结点 res 中，表示的意义是此时 node 的左子树已经全部捋直了，而且根结
    点就是 res，而且 node 结点本身也被连到了捋直后的左子树下，即此时左子结点和根结点已经完成了交换位子，当然要断开原来的连接，所以
    将 node->left 赋值为 null。然后再对 node 的右子结点调用递归函数，注意此时的 pre 不能传入 node 本身，而是要传 node 结点的 pre 结
    点，这是因为右子结点后面要连接的是 node 的父结点：
     */

    // 参考：https://github.com/grandyang/leetcode/issues/897
    public TreeNode increasingBST1(TreeNode root) {
        return helper(root, null);
    }

    public TreeNode helper(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, pre);
        return res;
    }
}
