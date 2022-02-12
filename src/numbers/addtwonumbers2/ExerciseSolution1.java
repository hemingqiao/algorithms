package src.numbers.addtwonumbers2;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/25 22:19:54
 * description:
 */
public class ExerciseSolution1 {
    /*
    这道题的一道扩展就是给出的两个链表不是倒序而是正序的
    力扣的输入是：
        输入：l1 = [2,4,3], l2 = [5,6,4]
        输出：[7,0,8]
        解释：342 + 465 = 807.
    变形的输入是：
        输入：l1 = [3,4,2], l2 = [4,6,5]
        输出：[8,0,7]

    就需要多处理两步：先将两个传入的链表反转，进行求和，然后将结果数组反转即可
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int temp = a + b + carry;
            p.next = new ListNode(temp % 10);
            p = p.next;
            carry = temp / 10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return dummy.next;
    }
}
