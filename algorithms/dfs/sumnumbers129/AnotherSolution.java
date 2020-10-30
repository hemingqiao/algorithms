package blogandquestion.algorithms.dfs.sumnumbers129;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/30 08:56:15
 * description: 利用深度优先搜索和回溯。
 * 解题思路
 * see: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/129-qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-di-4/
 */
public class AnotherSolution {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, path);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path) {
        if (root.left == null && root.right == null) { // 叶子节点
            res += add(path);
        }

        if (root.left != null) {
            path.add(root.left.val); // 处理当前节点
            dfs(root.left, path); // 递归
            path.remove(path.size() - 1); // 回溯
        }

        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, path);
            path.remove(path.size() - 1);
        }
    }

    private int add(List<Integer> list) {
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp = 10 * temp + list.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(3);
        AnotherSolution s = new AnotherSolution();
        int result = s.sumNumbers(test);
        System.out.println(result);
    }
}
