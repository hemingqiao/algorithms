package src.binarytree.lowestcommonancestor236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 18:51:39
 * description:
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 *
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 记录遍历到的每个节点的父节点
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        // queue用于进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点的父节点设为null
        parent.put(root, null);
        // 将根节点加入队列
        queue.add(root);
        // 当p或者q不在哈希表中时，继续循环
        // 直到两个节点都加入到了哈希表中，退出循环
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                // 左子节点不为空，记录下其父节点
                parent.put(node.left, node);
                // 将左子节点加入队列
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        HashSet<TreeNode> ancestors = new HashSet<>();
        // 记录p和p节点的所有祖先节点（直到根节点）
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        // 查看p和他的祖先节点是否包含q节点，如果不包含再看是否包含q的父节点
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
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
