package src.linkedlist.swappairs24;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/20 19:06:15
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 递归，重点在于理解递归是将大的问题分解为一个相同（类似）的规模更小的子问题，可以假设函数已经写好
    // 递归的出口需要注意
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode second = head.next;
        head.next = second.next;
        second.next = head;
        head.next = swapPairs(head.next);
        return second;
    }

    // 非递归解法
    // 参考：https://github.com/grandyang/leetcode/issues/24
    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next.next;
            pre.next.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        return dummy.next;
    }

    // 非递归解法2
    public ListNode swapPairs2(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;
        ListNode h = dummy; // 定义一个“头结点”
        while (pre != null && pre.next != null) {
            ListNode next = pre.next;
            pre.next = pre.next.next;
            next.next = pre;
            h.next = next;
            h = pre; // 更新头结点
            pre = pre.next;
        }
        return dummy.next;
    }
}
