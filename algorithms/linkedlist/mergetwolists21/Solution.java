package blogandquestion.algorithms.linkedlist.mergetwolists21;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/12 22:21:56
 * description:
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/xin-shou-you-hao-xue-hui-tao-lu-bu-fan-cuo-4nian-l/
 * see: https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/
 *
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode move = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }

        move.next = l1 == null ? l2 : l1;
        return head.next;
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
