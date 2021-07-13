package blogandquestion.algorithms.linkedlist.reversekgroup25;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/13 22:17:50
 * description:
 */
public class ExerciseSolution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int cnt = k;
        while (--cnt > 0 && p != null) {
            p = p.next;
        }
        if (p == null) return head;
        ListNode rest = p.next;
        p.next = null;
        ListNode reversed = reverse(head);
        head.next = reverseKGroup(rest, k);
        return reversed;
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode c = dummy.next;
        while (c != null && c.next != null) {
            ListNode next = c.next;
            c.next = c.next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }
}
