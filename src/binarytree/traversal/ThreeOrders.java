package src.binarytree.traversal;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/27 16:57:32
 * description:
 * @see https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=117&tqId=37819&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class ThreeOrders {
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        dfs(root);
        int[][] ret = new int[3][];
        int[] preorder = new int[pre.size()];
        int p = 0;
        for (int i : pre) preorder[p++] = i;
        p = 0;
        int[] inorder = new int[pre.size()];
        for (int i : in) inorder[p++] = i;
        p = 0;
        int[] postorder = new int[pre.size()];
        for (int i : post) postorder[p++] = i;
        ret[0] = preorder;
        ret[1] = inorder;
        ret[2] = postorder;
        return ret;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        pre.add(root.val);
        dfs(root.left);
        in.add(root.val);
        dfs(root.right);
        post.add(root.val);
    }
}
