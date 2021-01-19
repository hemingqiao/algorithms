package blogandquestion.algorithms.linkedlist.mergetwolists21;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/19 19:43:48
 * description:
 * 二刷
 */
public class ExerciseSolution {
    // 类似于双指针快排
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


    // 递归解法，重点是理解递归是将一个大的问题分解成了一个小的问题，而这个小的问题与大的问题是类似的，都能够使用这个方法求解
    // 递归的出口也需要注意
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2; // base case
        if (l2 == null) return l1; // base case
        ListNode ret;
        if (l1.val < l2.val) {
            ret = new ListNode(l1.val);
            ret.next = mergeTwoLists1(l1.next, l2);
        } else {
            ret = new ListNode(l2.val);
            ret.next = mergeTwoLists1(l1, l2.next);
        }
        return ret;
    }
}
