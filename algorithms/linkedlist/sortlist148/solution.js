/*! *****************************************************************************
@author Heming
founded at 2020-11-21 10:37:05
created by IntelliJ IDEA
description: LeetCode148 排序链表
from: https://leetcode-cn.com/problems/sort-list/
***************************************************************************** */

function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    if (head == null || head.next == null) return head;
    let slow = head; // 慢指针
    let fast = head.next; // 快指针

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    let rightHead = slow.next;
    slow.next = null;
    return merge(sortList(head), sortList(rightHead));

    /**
     * 归并两个有序链表
     * @param {ListNode} h1
     * @param {ListNode} h2
     * @return {ListNode}
     */
    function merge(h1, h2) {
        let dummy = new ListNode(-1);
        let p = dummy;
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
        if (h1 != null) p.next = h1;
        else if (h2 != null) p.next = h2;
        return dummy.next;
    }
};
