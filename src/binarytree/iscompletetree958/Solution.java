package src.binarytree.iscompletetree958;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/09 09:04:10
 * description:
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 *
 * 提示：
 *
 * 树中将会有 1 到 100 个结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 *
 * 参考：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/hen-jian-dan-de-si-lu-dai-ma-hen-jian-ji-by-yuanyb/
 */
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>(); // ArrayDequeue不可以存取null
        queue.add(root);
        TreeNode prev = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (prev == null && temp != null) {
                    return false;
                }
                if (temp != null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
                prev = temp;
            }
        }
        return true;
    }
}


/**
 * 参考：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/er-cha-shu-de-wan-quan-xing-jian-yan-by-leetcode/430956
 */
class AnotherSolution {
    int size = 0; // 记录二叉树节点的个数
    int maxCode = 0; // 记录二叉树节点对应的索引
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        dfs(root, 1); // 根节点索引为1
        return size == maxCode;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) return;
        size++; // 节点数加1
        maxCode = Math.max(maxCode, index);
        dfs(root.left, index * 2); // 递归遍历左子节点
        dfs(root.right, index * 2 + 1); // 递归遍历右子节点
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
