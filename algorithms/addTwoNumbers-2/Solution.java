package blogandquestion.algorithms.addtwonumbers2;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/04 12:00:14
 * description: 利用递归
 * see: https://leetcode-cn.com/problems/add-two-numbers/solution/java-tong-su-yi-dong-de-di-gui-by-leetcoder-youzg/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursive(l1, l2, 0);
    }

    private ListNode recursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) { // base case 递归结束条件
            return null;
        }

        int l1Val = l1 == null ? 0 : l1.val;
        int l2Val = l2 == null ? 0 : l2.val;
        int curSum = l1Val + l2Val + carry;
        ListNode curNode = new ListNode(curSum % 10);
        curNode.next = recursive(l1 == null ? null : l1.next, l2 == null ? null : l2.next, curSum / 10);
        return curNode;
    }
}


/**
 * Definition for singly-linked list.
 */
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
