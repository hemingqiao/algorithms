package src.linkedlist.ispalindrome234;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/18 20:05:49
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        tail = reverse(tail);
        while (head != null && tail != null) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        tail = reverse(tail);
        // 如果链表长度为奇数，则head的长度比tail多1，如果链表的长度为偶数，head和tail长度相等
        // 所以只需要对tail是否为空进行判断即可
        while (tail != null) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
