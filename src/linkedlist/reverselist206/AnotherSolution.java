package src.linkedlist.reverselist206;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/31 19:52:55
 * description: 使用一个哑节点和一个辅助节点。
 */
public class AnotherSolution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur.next != null) {
            ListNode temp = dummy.next; // 临时记录dummy.next
            dummy.next = cur.next; // 将节点插到头部
            cur.next = cur.next.next;
            dummy.next.next = temp; // 将头部新的节点与之前的链表连起来
        }
        return dummy.next;
    }
}
