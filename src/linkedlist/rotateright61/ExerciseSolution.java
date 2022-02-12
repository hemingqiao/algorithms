package src.linkedlist.rotateright61;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/27 13:30:26
 * description:
 * 二刷
 * 参考：https://github.com/grandyang/leetcode/issues/61
 */
public class ExerciseSolution {
    public ListNode rotateRight(ListNode head, int k) {
        // 当链表长度为1时，无论怎么旋转，最后返回的都是唯一的这个节点
        if (head == null || head.next == null) return head;
        ListNode p = head;
        int n = 1;
        while (p.next != null) {
            ++n;
            p = p.next;
        }
        p.next = head;
        int step = n - k % n;
        while (step-- > 0) {
            p = p.next;
        }
        ListNode ret = p.next;
        p.next = null; // 断开环
        return ret;
    }
}
