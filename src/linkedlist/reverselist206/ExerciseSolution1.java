package src.linkedlist.reverselist206;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/27 15:46:42
 * description:
 */
public class ExerciseSolution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = head.next;
        head.next = null;
        ListNode reversed = reverseList(rest);
        rest.next = head;
        return reversed;
    }
}
