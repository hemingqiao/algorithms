package blogandquestion.algorithms.linkedlist.reversekgroup25;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 15:11:30
 * description:给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 */
public class Solution {
    // 采用递归求解
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null; // 递归退出条件
        ListNode pre = head;
        ListNode cur = head;
        int count = 0;
        // 找到前k个，如果刚好找到k个，退出循环，如果链表长度不足k个，也退出循环
        while (cur != null) {
            count++;
            pre = cur;
            cur = cur.next;
            if (count == k) {
                break;
            }
        }
        // 因为上面退出循环有两个条件，需要判断count是否等于k
        if (count == k) {
            pre.next = null; // 断开前k个和后续节点之间的连接
            ListNode reversedNode = reverseList(head); // 将前k个节点反转
            ListNode t = reversedNode;
            while (t.next != null) {
                t = t.next;
            }
            t.next = reverseKGroup(cur, k); // 找到前k个节点的尾结点，并让这个尾结点的next指针指向递归调用剩余节点所返回的链表
            return reversedNode;
        } else {
            // 如果节点个数不足k个，直接返回
            return head;
        }
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode res = s.reverseKGroup(l, 3);
        System.out.println(res);
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
