package blogandquestion.algorithms.linkedlist.reorderlist143;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/29 21:00:57
 * description:
 * 这一道题就考察了三个点：快速找到链表的中间结点、反转链表、链表的插入
 * 参考：https://github.com/grandyang/leetcode/issues/143
 */
public class ExerciseSolution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        // 1、使用快慢指针将链表分为前后两部分
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        // 2、将后半部分链表反转
        ListNode cur = mid;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = mid;
            mid = next;
        }

        // 3、将反转后的链表间隔的插入前半部分
        while (head != null && mid != null) {
            ListNode next = head.next;
            head.next = mid;
            mid = mid.next;
            head.next.next = next;
            head = next;
        }
    }
}
