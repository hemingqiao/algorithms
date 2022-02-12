package src.linkedlist.deleteduplicates83;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/25 13:34:03
 * description:
 */
public class ExerciseSolution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode p = cur.next;
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                cur.next = p;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    // 递归解法
    // 参考：https://github.com/grandyang/leetcode/issues/83
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates1(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
