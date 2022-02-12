package src.linkedlist.reverselist206;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/20 19:45:16
 * description:
 * 二刷（这题要多刷）
 */
public class ExerciseSolution {
    // 头插法反转链表
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode n = cur.next;
            cur.next = n.next;
            n.next = head;
            head = n;
        }
        return head;
    }

    // 递归解法
    // modify at 2021/05/27
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head.next; // 反转之后，tail会成为最后一个节点
        head.next = null;
        ListNode reversed = reverseList1(tail);
        tail.next = head;
        return reversed;
    }
}
