package src.linkedlist.ispalindrome234;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 10:13:28
 * description:
 * 参考：https://leetcode-cn.com/problems/palindrome-linked-list/solution/di-gui-zhan-deng-3chong-jie-jue-fang-shi-zui-hao-d/
 */
public class AnotherSolution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            // 链表长度为奇数
            // 将slow后移一位
            slow = slow.next;
        }
        slow = reverseList(slow); // 将链表后半部分反转
        fast = head; // 将fast重新指回头部
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }
}
