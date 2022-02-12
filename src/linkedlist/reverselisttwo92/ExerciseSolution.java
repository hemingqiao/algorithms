package src.linkedlist.reverselisttwo92;



/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/28 21:15:08
 * description:
 * 二刷
 */
public class ExerciseSolution {
    /*
    // 关键在于找出需要进行反转的区间，然后就是反转链表的内容了
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        ListNode pre = dummy;
        int t = m;
        while (t-- > 1) {
            pre = p;
            p = p.next;
        }
        ListNode cur = p;
        while (cur.next != null && m++ < n) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = p;
            p = next;
            pre.next = p;
        }
        return dummy.next;
    }
    */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        ListNode pre = dummy;
        int t = m;
        while (t-- > 1) {
            pre = p;
            p = p.next;
        }
        while (p.next != null && m++ < n) {
            ListNode next = p.next;
            p.next = p.next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy; // pre要初始化为dummy，否则可能会出现空指针，如链表 2 -> 5，m = 1，n = 2
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        ListNode res = es.reverseBetween(test, 2, 4);
        System.out.println(res);
    }

    // 三刷
    // 2021/03/18
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode h = dummy;
        int i = 1;
        while (i++ < left && h != null) {
            h = h.next;
        }
        ListNode p = h.next;
        while (p != null && p.next != null && left++ < right) {
            ListNode next = p.next;
            p.next = p.next.next;
            next.next = h.next; // 头插法，将该结点插入到头结点后
            h.next = next;
        }
        return dummy.next;
    }
}
