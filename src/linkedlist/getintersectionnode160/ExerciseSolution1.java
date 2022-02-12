package src.linkedlist.getintersectionnode160;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/04 20:20:34
 * description:
 */
public class ExerciseSolution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (!set.add(p2)) return p2;
            p2 = p2.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            /*p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;*/
            // 需要能够让p1和p2在某个过程中等于null，如果是上面那样判断next是否为null，那么p1和p2始终不可能等于null
            // 那么当两个链表不相交时，就会出现死循环
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    public ListNode getIntersectionNode2(ListNode a, ListNode b) {
        Set<ListNode> set = new HashSet<>();
        while (a != null) {
            set.add(a);
            a = a.next;
        }
        while (b != null) {
            if (set.contains(b)) return b;
            b = b.next;
        }
        return null;
    }
}
