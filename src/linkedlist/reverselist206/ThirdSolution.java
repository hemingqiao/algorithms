package src.linkedlist.reverselist206;

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

class RecurSolution {
    // 递归解法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head.next;
        head.next = null; // 将head.next置空
        ListNode reversedNode = reverseList(tail); // 认为reverseList这个方法会成功的返回反转后的链表
        tail.next = head; // 因为要将tail的next指针指向head，所以tail不能为null，要在base case里进行判断
        return reversedNode;
    }
}
