package src.linkedlist.getintersectionnode160;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/27 09:32:11
 * description:
 */
public class ExerciseSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 如果两个链表不相交，最后pA == pB == null退出循环
        // 如果两个链表长度相同且不相交，第一次遍历结束二者均为null，退出循环
        // 如果两个链表长度不同且不相交，长度分别为la和lb，那么再遍历完la + lb长度后，pA和pB均为null，退出循环
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
