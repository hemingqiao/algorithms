package blogandquestion.algorithms.numbers.addtwonumbers2;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/09 16:13:55
 * description:
 */
public class ExerciseSolution {
    /*
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1.next != null) {
            p1 = p1.next;
        }
        while (p2.next != null) {
            p2 = p2.next;
        }

        // 给较短的链表进行补零，后来发现两个链表是低位对齐的，不需要提前进行补零，只需要相加时判断是否为空即可
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        int delta = Math.abs(len1 - len2);
        ListNode temp = new ListNode(-1);
        ListNode d = temp;
        while (delta-- > 0) {
            d.next = new ListNode(0);
            d = d.next;
        }
        if (len1 >= len2) {
            p2.next = temp.next;
        } else {
            p1.next = temp.next;
        }
        while (l1 != null) {
            int v = l1.val + l2.val + carry;
            cur.next = new ListNode(v % 10);
            carry = v / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private int getLength(ListNode l) {
        int cnt = 0;
        while (l != null) {
            cnt++;
            l = l.next;
        }
        return cnt;
    }
}
