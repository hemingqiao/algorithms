package blogandquestion.algorithms.linkedlist.swappairs24;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/13 21:20:53
 * description:
 */
public class AnotherSolution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode first = cur;
            ListNode second = cur.next;

            first.next = second.next;
            pre.next = second;
            second.next = first;

            pre = first;
            cur = first.next;
        }
        return dummy.next;
    }
}
