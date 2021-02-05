package blogandquestion.algorithms.linkedlist.deleteduplicates83;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/05 20:08:58
 * description:
 */
public class ExerciseSolution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode fast = head.next, slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        // 断开slow与后面重复节点的连接，如1 -> 2 -> 3 -> 3这种
        slow.next = null;
        return head;
    }
}
