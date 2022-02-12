package src.linkedlist.removeelements203;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 19:13:13
 * description: 创建一个哑节点，使用两个指针，一快一慢，遍历链表。
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

class AnotherSolution {
    // 只使用一个辅助节点
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 删除操作只是将cur指向下下个节点，就可以删除下一个节点了？
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
