package blogandquestion.algorithms.doublepointer.partition85;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/16 20:58:14
 * description:
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 *
 * 解题思路：
 * 将链表分割为两个链表，其中一个链表中的元素的值都小于给定值，另一个中的值都大于等于给定的值，最后将两个链表拼起来
 * see: https://leetcode-cn.com/problems/partition-list/solution/liang-ge-zi-lian-biao-pin-jie-han-zhu-shi-ji-bai-1/
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode part1 = less;
        ListNode greaterOrEqual = new ListNode(-1);
        ListNode part2 = greaterOrEqual;
        while (head != null) {
            if (head.val < x) {
                part1.next = new ListNode(head.val);
                part1 = part1.next;
            } else {
                part2.next = new ListNode(head.val);
                part2 = part2.next;
            }
            head = head.next;
        }
        part1.next = greaterOrEqual.next;
        return less.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
