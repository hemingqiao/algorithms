package src.linkedlist.addtwonumbers445;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/11 09:37:48
 * description:
 * 这一题和后面一道题的follow up相同
 * @see https://leetcode-cn.com/problems/sum-lists-lcci/
 */
public class ExerciseSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop().val;
            int b = stack2.isEmpty() ? 0 : stack2.pop().val;
            int t = a + b + carry;
            ListNode temp = new ListNode(t % 10);
            temp.next = head;
            head = temp;
            carry = t / 10;
        }
        return head;
    }
}
