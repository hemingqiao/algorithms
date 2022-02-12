package src.linkedlist.deleteduplicatestwo82;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/25 13:23:43
 * description:
 */
public class ExerciseSolution1 {
    // 三刷
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode p = cur.next;
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                cur.next = p.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 递归解法
    // 参考：https://github.com/grandyang/leetcode/issues/82
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates1(head.next);
        }
        head.next = deleteDuplicates1(head.next);
        return head;
    }
}
