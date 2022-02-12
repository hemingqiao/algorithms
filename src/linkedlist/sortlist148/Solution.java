package src.linkedlist.sortlist148;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 10:25:18
 * description:
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 *
 */
public class Solution {
    // 借助归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 使用快慢指针找到链表的中间节点
        // 注意这里fast没有从head开始而是从head.next开始的，此时循环结束时，slow.next指向的是中间结点
        // 如果slow和fast都是从head开始的，最终退出循环时，slow指向的是中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            // 慢指针每次移动一个位置，快指针每次移动两个位置
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow（中间节点）的next指针指向的就是右侧链表的头结点
        ListNode rightHead = slow.next;
        slow.next = null; // 切断两边链表的连接

        ListNode left = sortList(head); // 递归排序前一段链表
        ListNode right = sortList(rightHead); // 递归排序后一段链表
        return merge(left, right); // 合并两段链表
    }

    // 归并两个有序链表（合并）
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        // 下面两个条件只有一个会成立
        if (h1 != null) p.next = h1;
        else if (h2 != null) p.next = h2;
        return dummy.next;
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
