package blogandquestion.algorithms.linkedlist.sortlist148;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 20:20:45
 * description:
 * 二刷
 * 参考：https://github.com/grandyang/leetcode/issues/148
 */
public class ExerciseSolution {
    // 借鉴了归并排序的分治（divide and conquer）思想
    public ListNode sortList(ListNode head) {
        // 当链表只有一个结点时，链表一定是有序的，此时可以直接返回，当然还需要处理链表可能为空的情况
        if (head == null || head.next == null) return head;
        // 使用快慢指针找到链表中间结点的前一个结点（和设置哑节点，然后fast和slow同时从哑节点出发是一致的）
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tail);
        return merge(left, right);
    }

    // 归并两个链表
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
