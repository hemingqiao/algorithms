package blogandquestion.algorithms.linkedlist.deleteduplicatestwo82;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/21 22:11:46
 * description: 利用辅助节点。
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 *
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/javashuang-zhi-zhen-dai-ma-jiao-duan-rong-yi-li-ji/547071
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1); // 初始化一个辅助节点（哑节点）
        dummy.next = head;
        ListNode cur = dummy; // 初始化一个辅助指针
        // 通过移动辅助指针来遍历链表
        while (cur.next != null && cur.next.next != null) {
            // 判断当前节点的下一个节点的值和下下个节点的值是否相等
            if (cur.next.val == cur.next.next.val) {
                // 初始化一个待删除节点，一步步的将待删除节点移到待删除（重复值）链表的最后一个位置
                ListNode temp = cur.next;
                // 对temp != null的判断可以省略掉
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                // 将辅助指针指向temp节点的下一个节点，就实现删除了重复值的节点
                cur.next = temp.next;
            } else {
                cur = cur.next; // 继续移动辅助指针进行遍历
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
