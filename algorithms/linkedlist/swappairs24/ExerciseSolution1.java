package blogandquestion.algorithms.linkedlist.swappairs24;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/15 20:39:37
 * description:
 */
public class ExerciseSolution1 {
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode c = dummy.next;
        int cnt = k;
        while (--cnt > 0 && c != null) c = c.next;
        if (c == null) return head;
        ListNode rest = c.next;
        c.next = null;
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
