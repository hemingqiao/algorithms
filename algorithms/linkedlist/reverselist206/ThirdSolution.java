package blogandquestion.algorithms.linkedlist.reverselist206;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 21:45:55
 * description: 使用头插法反转链表。
 * 参考
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-tou-cha-fa-di-gui-by-heng-29/
 */
public class ThirdSolution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head; // 将cur插入到头部，cur.next = head
            head = cur; // 更新头部
            cur = pre.next; // 将cur移到pre的后面
        }
        return head;
    }
}
