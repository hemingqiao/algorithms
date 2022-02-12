package src.linkedlist.ispalindrome234;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 09:01:05
 * description:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 *
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        int low = 0, high = res.size() - 1;
        while (low < high) {
            if (!res.get(low++).equals(res.get(high--))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode test = new ListNode(1);
        test.next = new ListNode(1);
        test.next.next = new ListNode(2);
        test.next.next.next = new ListNode(1);
        test.next.next.next.next = null;
        boolean res = s.isPalindrome(test);
        System.out.println(res);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
