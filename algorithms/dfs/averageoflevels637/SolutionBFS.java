package blogandquestion.algorithms.dfs.averageoflevels637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/23 19:33:03
 * description: 利用BFS层序遍历，执行时间略慢，击败71。
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 *
 */
public class SolutionBFS {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double temp = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                temp += t.val;
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            res.add(temp / size);
        }
        return res;
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
