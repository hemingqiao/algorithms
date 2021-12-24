package blogandquestion.algorithms.linkedlist.splitlisttoparts725;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/22 19:28:18
 * description:
 */
public class ExerciseSolution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode p = head;
        int n = 0, idx = 0;
        while (p != null) {
            ++n;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < k; i++) {
            int len = n / k;
            if (i + 1 <= n % k) len++;
            res[idx++] = p;
            for (int j = 0; j < len - 1; j++) p = p.next;
            if (p != null) {
                ListNode q = p.next;
                p.next = null;
                p = q;
            }
        }
        return res;
    }
}
