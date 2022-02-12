package src.linkedlist.reversekgroup25;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/20 19:37:54
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 非递归解法
    // 参考：https://github.com/grandyang/leetcode/issues/25
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        while (count >= k) {
            cur = pre.next;
            for (int i = 1; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }

    // 递归解法
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            pre = cur;
            cur = cur.next;
            if (count == k) {
                break;
            }
        }
        if (count == k) {
            pre.next = null;
            ListNode reversed = reverse(head);
            ListNode t = reversed;
            while (t.next != null) {
                t = t.next;
            }
            t.next = reverseKGroup1(cur, k);
            return reversed;
        } else {
            return head;
        }
    }

    public ListNode reverse(ListNode head) {
        // 头插法反转链表
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode n = cur.next;
            cur.next = n.next;
            n.next = head;
            head = n;
        }
        return head;
    }
}
