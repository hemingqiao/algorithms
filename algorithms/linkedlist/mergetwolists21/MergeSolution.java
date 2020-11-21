package blogandquestion.algorithms.linkedlist.mergetwolists21;

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
