package blogandquestion.algorithms.linkedlist.reverselisttwo92;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/15 21:46:02
 * description:
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode guard = dummyHead;
        ListNode pointer = dummyHead.next;
        int step = m;
        while (step > 1) {
            guard = pointer;
            pointer = pointer.next;
            step--;
        }

        ListNode removed = null;
        for (int i = 0; i < n - m; i++) {
            // 守卫节点不动，将pointer指向的节点依次插到guard的后面，头插法
            removed = pointer.next;
            pointer.next = pointer.next.next;

            removed.next = guard.next;
            guard.next = removed;
        }

        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}