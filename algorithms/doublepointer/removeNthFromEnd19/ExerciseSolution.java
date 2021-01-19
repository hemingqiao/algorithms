package blogandquestion.algorithms.doublepointer.removenthfromend19;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/19 18:53:59
 * description:
 */
public class ExerciseSolution {
    // 使用三个指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        ListNode pre = dummy;
        int p = 0;
        while (p < n && fast != null) {
            fast = fast.next;
            p++;
        }
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }

    // 使用两个指针，与上面三指针不同之处在于找到待删除节点的前一个节点后停止，不需要再定义第三个指针来指向这个位置
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int p = 0;
        while (p < n && fast != null) {
            fast = fast.next;
            p++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
