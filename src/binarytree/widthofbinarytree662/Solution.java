package src.binarytree.widthofbinarytree662;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/01 09:40:51
 * description: 需要记录每个节点的深度和位置信息。
 * 解题思路
 * see: https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode/
 * see: https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/zui-yi-dong-zui-xiang-xi-de-ti-jie-liao-by-a969295/
 * see: https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/java-di-yi-ci-shuang-bai-mu-ha-ha-ji-nian-xia-by-z/
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 *
 */
public class Solution {
    int ans;
    Map<Integer, Integer> map;
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        map = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return; // base case，如果root为null，返回，结束递归
        map.computeIfAbsent(depth, x -> pos); // 当第一次进入某一层的时候，此时map中depth对应的键值为空，添加这层最左侧节点的位置信息
        ans = Math.max(ans, pos - map.get(depth) + 1);
        depth++;
        // 左子结点的位置相对于根节点是二倍的关系，右子节点的位置相对于根节点是二倍加一的关系
        // 每一层的最左的节点的位置始终是0，这一层的最大宽度是其他节点的位置减去这一层首个节点的位置再加上一
        dfs(root.left, depth, pos * 2);
        dfs(root.right, depth, pos * 2 + 1);
    }
}

class SolutionBFS {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0, 1));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.node != null) {
                queue.add(new Node(temp.node.left, temp.depth + 1, temp.postion * 2));
                queue.add(new Node(temp.node.right, temp.depth + 1, temp.postion * 2 + 1));
                if (curDepth != temp.depth) {
                    curDepth = temp.depth;
                    left = temp.postion;
                }
                ans = Math.max(ans, temp.postion - left + 1);
            }
        }
        return ans;
    }

    /**
     * 定义了一个新的节点，同时记录原有节点信息，树的深度和节点的位置信息
     */
    class Node {
        TreeNode node;
        int depth;
        int postion;
        Node (TreeNode node, int depth, int postion) {
            this.node = node;
            this.depth = depth;
            this.postion = postion;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
