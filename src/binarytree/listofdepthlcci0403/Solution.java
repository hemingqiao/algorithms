package src.binarytree.listofdepthlcci0403;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/05 13:06:12
 * description:
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 *
 * 层序遍历。
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        List<ListNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                cur.next = new ListNode(temp.val);
                cur = cur.next;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            list.add(dummy.next);
        }
        int length = list.size();
        ListNode[] res = new ListNode[length];
        for (int i = 0; i < length; i++) {
            res[i] = list.get(i);
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
