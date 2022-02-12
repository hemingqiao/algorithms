package src.linkedlist.mergetwolists21;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 10:55:31
 * description:
 */
public class MergeSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        // 退出上面的循环后，l1和l2可能只有一个为null，需要额外判断一下
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}

class RecurSolution {
    // 递归解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            // 在这里假定mergeTwoLists能够正确的返回合并l1.next和l2的链表
            // 然后将l1的next指针指向这个返回的链表，然后返回l1作为结果
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
