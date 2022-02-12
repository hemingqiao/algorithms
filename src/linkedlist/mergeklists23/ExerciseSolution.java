package src.linkedlist.mergeklists23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/20 14:27:36
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        ListNode ret = lists[0];
        for (int i = 1; i < n; i++) {
            ret = mergeTwoLists(ret, lists[i]);
        }
        return ret;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) queue.add(l);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            ListNode rest = temp.next;
            if (rest != null) {
                queue.add(rest);
            }
            temp.next = null;
            p.next = temp;
            p = p.next;
        }
        return dummy.next;
    }

    // 分治，类似于归并排序
    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) >>> 1;
        ListNode l = merge(lists, left, mid);
        ListNode r = merge(lists, mid + 1, right);
        return mergeTwoNode(l, r);
    }

    public ListNode mergeTwoNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
