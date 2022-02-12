package src.linkedlist.deleteduplicates83;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/21 22:30:46
 * description: 解题思路和删除重复节点II的类似。还可以使用快慢双指针来处理。
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 *
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
