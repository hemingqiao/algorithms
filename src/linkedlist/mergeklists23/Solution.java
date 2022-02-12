package src.linkedlist.mergeklists23;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 11:34:25
 * description:
 */
public class Solution {
    // 复用之前合并两个有序链表的代码
    // 执行时间比较长
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode l0 = lists[0];
        for (int i = 1; i < lists.length; i++) {
            l0 = merge(l0, lists[i]);
        }
        return l0;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
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
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
