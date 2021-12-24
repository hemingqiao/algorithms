package blogandquestion.algorithms.linkedlist.reverselist206;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/28 16:24:33
 * description:
 */
public class AddList {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode r1 = reverse(head1);
        ListNode r2 = reverse(head2);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (r1 != null || r2 != null || carry != 0) {
            int a = r1 == null ? 0 : r1.val;
            int b = r2 == null ? 0 : r2.val;
            r1 = r1 == null ? r1 : r1.next;
            r2 = r2 == null ? r2 : r2.next;
            int temp = a + b + carry;
            p.next = new ListNode(temp % 10);
            p = p.next;
            carry = temp / 10;
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            head.next.next = dummy.next;
            dummy.next = head.next;
            head.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(3);
        AddList ad = new AddList();
        ListNode res = ad.addInList(l1, l2);
    }
}
