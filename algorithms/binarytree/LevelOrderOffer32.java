package blogandquestion.algorithms.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 20:28:10
 * description:
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 *
 */
public class LevelOrderOffer32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        int[] res = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
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

/**
 * DFS深度优先搜索加回溯
 */
class SolutionDFS {
    int count = 0;
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        int[] arr = new int[count];
        int i = 0;
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                arr[i++] = integer;
            }
        }
        return arr;
    }

    // depth记录了树的深度，通过使用depth将同一层元素加到同一个list中
    private void dfs(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        } else {
            res.get(depth).add(root.val);
        }
        count++;

        // 这个地方隐藏有回溯
        dfs(res, root.left, depth + 1);
        dfs(res, root.right, depth + 1);
    }
}
