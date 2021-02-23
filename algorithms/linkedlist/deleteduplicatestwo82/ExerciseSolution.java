package blogandquestion.algorithms.linkedlist.deleteduplicatestwo82;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/23 20:08:07
 * description:
 * 二刷，这题掌握的不好
 */
public class ExerciseSolution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode t = cur.next;
                while (t != null && t.next != null && t.val == t.next.val) {
                    t = t.next;
                }
                cur.next = t.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 递归解法
    // 参考：https://github.com/grandyang/leetcode/issues/82
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return head;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
