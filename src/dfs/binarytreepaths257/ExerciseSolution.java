package src.dfs.binarytreepaths257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/25 20:23:56
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 10ms
    public List<String> binaryTreePaths1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs1(list, "", root);
        return list;
    }

    public void dfs1(List<String> list, String s, TreeNode root) {
        if (root.left == null && root.right == null) {
            s += root.val;
            list.add(s);
            return;
        }
        s = s + root.val + "->";
        if (root.left != null) dfs1(list, s, root.left);
        if (root.right != null) dfs1(list, s, root.right);
    }


    // 1ms(100%)
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(list, new StringBuilder(), root);
        return list;
    }

    public void dfs(List<String> list, StringBuilder s, TreeNode root) {
        if (root.left == null && root.right == null) {
            int len = s.length();
            s.append(root.val);
            list.add(s.toString());
            s.delete(len, s.length());
            return;
        }
        // 记住递归进入更深层之前的长度，方便进行回溯
        int len = s.length();
        s.append(root.val).append("->");
        if (root.left != null) dfs(list, s, root.left);
        if (root.right != null) dfs(list, s, root.right);
        // 回溯
        s.delete(len, s.length());
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.left.right = new TreeNode(5);
        test.right = new TreeNode(3);
        List<String> res = es.binaryTreePaths(test);
        System.out.println(res);
    }
}
