package src.linkedlist.removeelements203;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/05 08:18:45
 * description:
 */
public class ExerciseSolution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    // 这种解法妙啊
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
