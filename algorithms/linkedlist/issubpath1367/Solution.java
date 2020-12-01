package blogandquestion.algorithms.linkedlist.issubpath1367;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 22:19:10
 * description:
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 *
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 *
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 *
 *
 * 示例 1：
 *
 * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 解释：树中蓝色的节点构成了与链表对应的子路径。
 * 示例 2：
 *
 * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 示例 3：
 *
 * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：false
 * 解释：二叉树中不存在一一对应链表的路径。
 *
 * 提示：
 *
 * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
 * 链表包含的节点数目在 1 到 100 之间。
 * 二叉树包含的节点数目在 1 到 2500 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree
 *
 * 参考：https://leetcode-cn.com/problems/linked-list-in-binary-tree/solution/zhe-ti-jiu-shi-subtreeyi-mao-yi-yang-by-jerry_nju/
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true; // 如果链表为null，返回true
        if (root == null) return false; // 如果二叉树为null，返回false

        // 先判断当前节点，如果返回false，再看左子树和右子树
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSub(ListNode head, TreeNode root) {
        if (head == null) return true; // 如果链表走完了，返回true
        if (root == null) return false; // 如果树走完了，而链表没有走完，返回false
        // 如果当前节点链表值和树的值不同，返回false
        if (head.val != root.val) {
            return false;
        }
        // 如果链表节点值和树当前节点值相同，递归，查看树的左子树和右子树，有一个满足条件即可
        return isSub(head.next, root.left) || isSub(head.next, root.right);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
