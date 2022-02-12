package src.doublepointer.removenthfromend19;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/13 22:01:23
 * description: 自己想出来的解法，提交时超越了双百，纪念一下。
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *
 * 解题思路
 * 定义一个新的头节点（伪节点），使用快慢指针。要删除倒数第n个节点，让快指针先先后移动n个节点，然后两个指针以相同速度向后移动。
 * 当快指针到达链表尾部时，慢指针的下一个节点就是待删除的节点。
 */
public class MySolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;
        while (n > 0 && fast.next != null) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
